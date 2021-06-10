package com.xzinoviou.cqrs.domain.jpa;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : Xenofon Zinoviou
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class BankAccount {

  @Id
  private String id;

  private String owner;

  private BigDecimal balance;
}
