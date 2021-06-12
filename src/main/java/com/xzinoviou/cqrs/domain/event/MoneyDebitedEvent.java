package com.xzinoviou.cqrs.domain.event;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author : Xenofon Zinoviou
 */
@Getter
@AllArgsConstructor
public class MoneyDebitedEvent {

  private final String id;

  private final BigDecimal debitAmount;

}
