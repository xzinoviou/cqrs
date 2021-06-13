package com.xzinoviou.cqrs.controller.command;

import com.xzinoviou.cqrs.domain.jpa.Account;
import com.xzinoviou.cqrs.dto.AccountCreateDto;
import com.xzinoviou.cqrs.service.command.AccountCommandService;
import java.util.concurrent.CompletableFuture;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Xenofon Zinoviou
 */
@RestController
@RequestMapping("/accounts")
public class AccountCommandController {

  private final AccountCommandService accountCommandService;

  public AccountCommandController(
      AccountCommandService accountCommandService) {
    this.accountCommandService = accountCommandService;
  }

  @PostMapping
  public CompletableFuture<Account> create(AccountCreateDto dto){
    return accountCommandService.create(dto);
  }
}
