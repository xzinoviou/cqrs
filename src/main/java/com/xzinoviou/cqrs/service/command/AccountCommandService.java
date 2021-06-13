package com.xzinoviou.cqrs.service.command;

import com.xzinoviou.cqrs.domain.jpa.Account;
import com.xzinoviou.cqrs.dto.AccountCreateDto;
import java.util.concurrent.CompletableFuture;

/**
 * @author : Xenofon Zinoviou
 */
public interface AccountCommandService {

  CompletableFuture<Account> create(AccountCreateDto dto);
}
