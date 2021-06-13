package com.xzinoviou.cqrs.domain.query;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author : Xenofon Zinoviou
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountQuery {

  private String accountId;
}
