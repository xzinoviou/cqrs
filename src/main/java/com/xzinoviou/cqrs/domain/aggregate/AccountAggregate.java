package com.xzinoviou.cqrs.domain.aggregate;

import com.xzinoviou.cqrs.domain.command.CreateAccountCommand;
import com.xzinoviou.cqrs.event.AccountCreatedEvent;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

/**
 * @author : Xenofon Zinoviou
 */

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Aggregate
public class AccountAggregate {

  @AggregateIdentifier
  private String id;

  private BigDecimal balance;

  private String owner;


  @CommandHandler
  public AccountAggregate(CreateAccountCommand command) {
    new AccountCreatedEvent(
        command.getId(),
        command.getInitialBalance(),
        command.getOwner()
    );
  }

  @EventSourcingHandler
  public void on(AccountCreatedEvent event) {
    this.id = event.getId();
    this.balance = event.getInitialBalance();
    this.owner = event.getOwner();
  }
}
