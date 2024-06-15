package com.bankingsystem.accountservice.service;

import com.bankingsystem.accountservice.exception.ResourceNotFoundException;
import com.bankingsystem.accountservice.model.Account;
import com.bankingsystem.accountservice.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    // Method to save an account
    public Account saveAccount(Account account) {
        return accountRepository.save(account);
    }

    // Method to retrieve all accounts
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    // Method to retrieve an account by ID
    public Optional<Account> getAccountById(Long id) {
        return accountRepository.findById(id);
    }

    // Method to update an existing account
    public Account updateAccount(Long id, Account accountDetails) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found with id " + id));

        account.setLastname(accountDetails.getLastname());
        account.setEmail(accountDetails.getEmail());
        account.setOpeningAmount(accountDetails.getOpeningAmount());

        return accountRepository.save(account);
    }

    // Method to delete an account
    public void deleteAccount(Long id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found with id " + id));
        accountRepository.delete(account);
    }
}
