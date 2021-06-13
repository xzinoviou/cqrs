package com.xzinoviou.cqrs.controller.command;

import com.xzinoviou.cqrs.domain.jpa.Account;
import com.xzinoviou.cqrs.dto.AccountCreateDto;
import com.xzinoviou.cqrs.dto.MoneyAmountDto;
import com.xzinoviou.cqrs.service.command.AccountCommandService;
import java.util.concurrent.CompletableFuture;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
  public CompletableFuture<Account> create(@RequestBody AccountCreateDto dto) {
    return accountCommandService.create(dto);
  }


  @PutMapping("/credit")
  public CompletableFuture<String> credit(@RequestBody MoneyAmountDto dto) {
    return accountCommandService.credit(dto);
  }

  @PutMapping("/debit")
  public CompletableFuture<String> debit(MoneyAmountDto dto) {
    return accountCommandService.debit(dto);
  }
}
