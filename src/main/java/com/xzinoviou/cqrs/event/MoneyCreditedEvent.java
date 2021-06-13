package com.xzinoviou.cqrs.event;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author : Xenofon Zinoviou
 */
@Getter
@AllArgsConstructor
public class MoneyCreditedEvent {

  private final String id;

  private final BigDecimal creditAmount;
}
