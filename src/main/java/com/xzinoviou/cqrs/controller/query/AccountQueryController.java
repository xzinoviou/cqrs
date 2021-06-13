package com.xzinoviou.cqrs.controller.query;

import com.xzinoviou.cqrs.domain.jpa.Account;
import com.xzinoviou.cqrs.service.query.AccountQueryService;
import java.util.concurrent.CompletableFuture;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Xenofon Zinoviou
 */
@RestController
@RequestMapping("/accounts")
public class AccountQueryController {

  private final AccountQueryService accountQueryService;

  public AccountQueryController(
      AccountQueryService accountQueryService) {
    this.accountQueryService = accountQueryService;
  }

  @GetMapping("/{accountId}")
  public CompletableFuture<Account> getAccountById(@PathVariable String accountId) {
    return accountQueryService.getAccountById(accountId);
  }
}
