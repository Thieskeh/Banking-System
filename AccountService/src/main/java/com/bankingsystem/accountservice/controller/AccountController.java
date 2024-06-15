package com.bankingsystem.accountservice.controller;

import com.bankingsystem.accountservice.exception.ResourceNotFoundException;
import com.bankingsystem.accountservice.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bankingsystem.accountservice.service.AccountService;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        Account savedAccount = accountService.saveAccount(account);
        return ResponseEntity.ok(savedAccount);
    }

    @GetMapping
    public ResponseEntity<List<Account>> getAllAccounts() {
        List<Account> accounts = accountService.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable Long id) {
        Account account = accountService.getAccountById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found with id " + id));
        return ResponseEntity.ok(account);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Account> updateAccount(@PathVariable Long id, @RequestBody Account accountDetails) {
        Account updatedAccount = accountService.updateAccount(id, accountDetails);
        return ResponseEntity.ok(updatedAccount);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);
        return ResponseEntity.noContent().build();
    }
}
