package com.xzinoviou.cqrs.dto;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author : Xenofon Zinoviou
 */
@Getter
@AllArgsConstructor
public class MoneyAmountDto {

  private final String id;

  private final BigDecimal amount;
}
