package com.bankingsystem.accountservice.controller;

import com.bankingsystem.accountservice.exception.ResourceNotFoundException;
import com.bankingsystem.accountservice.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bankingsystem.accountservice.service.AccountService;

import java.util.List;

/**
 * This class is responsible for handling HTTP requests related to Account operations.
 * It uses the AccountService to perform CRUD operations on Account entities.
 */
@RestController
@RequestMapping("/accounts")
public class AccountController {

    /**
     * The AccountService instance used for performing Account operations.
     */
    @Autowired
    private AccountService accountService;

    /**
     * Creates a new Account.
     *
     * @param account The Account object to be created.
     * @return The ResponseEntity containing the created Account.
     */
    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        Account savedAccount = accountService.saveAccount(account);
        return ResponseEntity.ok(savedAccount);
    }

    /**
     * Retrieves all Accounts.
     *
     * @return The ResponseEntity containing a list of all Accounts.
     */
    @GetMapping
    public ResponseEntity<List<Account>> getAllAccounts() {
        List<Account> accounts = accountService.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }

    /**
     * Retrieves an Account by its ID.
     *
     * @param id The ID of the Account to be retrieved.
     * @return The ResponseEntity containing the retrieved Account.
     * @throws ResourceNotFoundException If the Account with the given ID is not found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable Long id) {
        Account account = accountService.getAccountById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found with id " + id));
        return ResponseEntity.ok(account);
    }

    /**
     * Updates an existing Account.
     *
     * @param id The ID of the Account to be updated.
     * @param accountDetails The updated Account details.
     * @return The ResponseEntity containing the updated Account.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Account> updateAccount(@PathVariable Long id, @RequestBody Account accountDetails) {
        Account updatedAccount = accountService.updateAccount(id, accountDetails);
        return ResponseEntity.ok(updatedAccount);
    }

    /**
     * Deletes an Account by its ID.
     *
     * @param id The ID of the Account to be deleted.
     * @return The ResponseEntity with no content (status 204).
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);
        return ResponseEntity.noContent().build();
    }
}
