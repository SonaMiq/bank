package com.sonamik.bank.repo;

import com.sonamik.bank.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepo extends JpaRepository<Account,Long> {
}
