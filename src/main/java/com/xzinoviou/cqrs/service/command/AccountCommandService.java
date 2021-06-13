package com.xzinoviou.cqrs.service.command;

import com.xzinoviou.cqrs.domain.jpa.Account;
import com.xzinoviou.cqrs.dto.AccountCreateDto;
import com.xzinoviou.cqrs.dto.MoneyAmountDto;
import java.util.concurrent.CompletableFuture;

/**
 * @author : Xenofon Zinoviou
 */
public interface AccountCommandService {

  CompletableFuture<Account> create(AccountCreateDto dto);

  CompletableFuture<String> credit(MoneyAmountDto dto);

  CompletableFuture<String> debit(MoneyAmountDto dto);
}
