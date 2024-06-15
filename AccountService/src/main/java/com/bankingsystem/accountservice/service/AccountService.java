package com.bankingsystem.accountservice.service;

import com.bankingsystem.accountservice.exception.ResourceNotFoundException;
import com.bankingsystem.accountservice.model.Account;
import com.bankingsystem.accountservice.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * This class represents the Account Service which provides methods to interact with the Account Repository.
 */
@Service
public class AccountService {

    /**
     * The Account Repository to interact with the database.
     */
    @Autowired
    private AccountRepository accountRepository;

    /**
     * Saves a new account in the database.
     *
     * @param account The account to be saved.
     * @return The saved account.
     */
    public Account saveAccount(Account account) {
        return accountRepository.save(account);
    }

    /**
     * Retrieves all accounts from the database.
     *
     * @return A list of all accounts.
     */
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    /**
     * Retrieves an account by its ID from the database.
     *
     * @param id The ID of the account to be retrieved.
     * @return An Optional containing the account if found, otherwise an empty Optional.
     */
    public Optional<Account> getAccountById(Long id) {
        return accountRepository.findById(id);
    }

    /**
     * Updates an existing account in the database.
     *
     * @param id The ID of the account to be updated.
     * @param accountDetails The updated account details.
     * @return The updated account.
     * @throws ResourceNotFoundException If the account with the given ID is not found.
     */
    public Account updateAccount(Long id, Account accountDetails) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found with id " + id));

        account.setLastname(accountDetails.getLastname());
        account.setEmail(accountDetails.getEmail());
        account.setOpeningAmount(accountDetails.getOpeningAmount());

        return accountRepository.save(account);
    }

    /**
     * Deletes an account from the database.
     *
     * @param id The ID of the account to be deleted.
     * @throws ResourceNotFoundException If the account with the given ID is not found.
     */
    public void deleteAccount(Long id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found with id " + id));
        accountRepository.delete(account);
    }
}
