package com.sonamik.bank.service;

import com.sonamik.bank.entity.Account;
import com.sonamik.bank.repo.AccountRepo;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    private AccountRepo accountRepo;

    AccountService(AccountRepo accountRepo) {
        this.accountRepo = accountRepo;
    }

    public void createAccount(Account account) {
        //  account.setIban(IBAN.ibanGenerator(account.getIssuer()));
        accountRepo.save(account);
    }

    public void deleteAccount(Long id) {
        accountRepo.delete(accountRepo.findById(id).get());
    }

    public void updateAccount(Long id, Account account) {
        Account find = accountRepo.findById(id).get();
        find.setBalance(account.getBalance());
        find.setIssuer(account.getIssuer());
        // find.setIban(IBAN.ibanGenerator(account.getIssuer()));
        accountRepo.save(find);
    }
}
