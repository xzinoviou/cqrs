package com.xzinoviou.cqrs.service.command;

import com.xzinoviou.cqrs.domain.command.CreateAccountCommand;
import com.xzinoviou.cqrs.domain.jpa.Account;
import com.xzinoviou.cqrs.dto.AccountCreateDto;
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
}
