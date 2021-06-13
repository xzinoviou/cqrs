package com.xzinoviou.cqrs.projector;

import com.xzinoviou.cqrs.domain.jpa.Account;
import com.xzinoviou.cqrs.event.AccountCreatedEvent;
import com.xzinoviou.cqrs.repository.AccountRepository;
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
}
