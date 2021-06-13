package com.xzinoviou.cqrs.service.query;

import com.xzinoviou.cqrs.domain.jpa.Account;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @author : Xenofon Zinoviou
 */
public interface AccountQueryService {

  CompletableFuture<Account> getAccountById(String accountId);

  List<Object> getAllEventsByAccountId(String accountId);
}
