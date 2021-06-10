package com.xzinoviou.cqrs.domain.command;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

/**
 * @author : Xenofon Zinoviou
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateAccountCommand {

  @TargetAggregateIdentifier
  private String id;

  private BigDecimal initialBalance;

  private String owner;
}