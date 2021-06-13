package com.xzinoviou.cqrs.repository;

import com.xzinoviou.cqrs.domain.jpa.Account;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : Xenofon Zinoviou
 */
public interface AccountRepository extends JpaRepository<Account, String> {
}
