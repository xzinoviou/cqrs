package com.xzinoviou.cqrs.service.command;

import com.xzinoviou.cqrs.domain.command.CreateAccountCommand;
import com.xzinoviou.cqrs.domain.command.CreditMoneyCommand;
import com.xzinoviou.cqrs.domain.command.DebitMoneyCommand;
import com.xzinoviou.cqrs.domain.jpa.Account;
import com.xzinoviou.cqrs.dto.AccountCreateDto;
import com.xzinoviou.cqrs.dto.MoneyAmountDto;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

/**
 * @author : Xenofon Zinoviou
 */
@Service
public class AccountCommandServiceImpl implements AccountCommandService {

  private final CommandGateway commandGateway;

  public AccountCommandServiceImpl(
      CommandGateway commandGateway) {
    this.commandGateway = commandGateway;
  }

  @Override
  public CompletableFuture<Account> create(AccountCreateDto dto) {
    return commandGateway.send(
        CreateAccountCommand.builder()
            .id(UUID.randomUUID().toString())
            .initialBalance(dto.getInitialBalance())
            .owner(dto.getOwner())
            .build()
    );
  }

  @Override
  public CompletableFuture<String> credit(MoneyAmountDto dto) {
    return commandGateway.send(
        CreditMoneyCommand.builder()
            .id(dto.getId())
            .creditAmount(dto.getAmount())
            .build()
    );
  }

  @Override
  public CompletableFuture<String> debit(MoneyAmountDto dto) {
    return commandGateway.send(
        DebitMoneyCommand.builder()
            .id(dto.getId())
            .debitAmount(dto.getAmount())
    );
  }
}
