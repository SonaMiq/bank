package com.sonamik.bank.controller;

import com.sonamik.bank.entity.Account;
import com.sonamik.bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;



    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public void createAccount(@RequestBody Account account) {
        accountService.createAccount(account);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAccount(@PathVariable("id") Long id) {
        accountService.deleteAccount(id);
    }

    @PutMapping("/update/{id}")
    public void updateAccount(@PathVariable("id") Long id, @RequestBody Account account) {
        accountService.updateAccount(id, account);
    }


}
