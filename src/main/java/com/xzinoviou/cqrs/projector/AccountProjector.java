package com.xzinoviou.cqrs.projector;

import com.xzinoviou.cqrs.domain.jpa.Account;
import com.xzinoviou.cqrs.event.AccountCreatedEvent;
import com.xzinoviou.cqrs.event.MoneyCreditedEvent;
import com.xzinoviou.cqrs.event.MoneyDebitedEvent;
import com.xzinoviou.cqrs.repository.AccountRepository;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

/**
 * @author : Xenofon Zinoviou
 */
@Slf4j
@Component
public class AccountProjector {

  private final AccountRepository accountRepository;

  public AccountProjector(AccountRepository accountRepository) {
    this.accountRepository = accountRepository;
  }

  @EventHandler
  public void on(AccountCreatedEvent event) {
    log.debug("Account creation command with payload : {}", event);

    Account account = Account.builder()
        .id(event.getId())
        .balance(event.getInitialBalance())
        .owner(event.getOwner())
        .build();

    try {
      accountRepository.save(account);
    } catch (Exception e) {
      log.debug("Account creation failed : {} , with payload : {}", e.getMessage(), event);
    }

  }

  @EventHandler
  public void on(MoneyCreditedEvent event) {
    log.debug("Account credit command with payload : {}", event);

    Optional<Account> optionalBankAccount = accountRepository.findById(event.getId());

    if (optionalBankAccount.isEmpty()) {
      throw new RuntimeException("Account not found");
    }

    Account account = optionalBankAccount.get();
    account.setBalance(account.getBalance().add(event.getCreditAmount()));

    try {
      accountRepository.save(account);
    } catch (Exception e) {
      log.debug("Account credit failed : {} , with payload : {}", e.getMessage(), event);
    }
  }

  @EventHandler
  public void on(MoneyDebitedEvent event) {
    log.debug("Account debit command with payload : {}", event);

    Optional<Account> optionalBankAccount = accountRepository.findById(event.getId());

    if (optionalBankAccount.isEmpty()) {
      throw new RuntimeException("Account not found");
    }

    Account account = optionalBankAccount.get();
    account.setBalance(account.getBalance().subtract(event.getDebitAmount()));

    try {
      accountRepository.save(account);
    } catch (Exception e) {
      log.debug("Account debit failed : {} , with payload : {}", e.getMessage(), event);
    }
  }
}
