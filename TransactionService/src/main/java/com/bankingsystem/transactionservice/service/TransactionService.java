package com.bankingsystem.transactionservice.service;

import com.bankingsystem.transactionservice.model.Account;
import com.bankingsystem.transactionservice.model.Transaction;
import com.bankingsystem.transactionservice.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * This class is responsible for managing transactions in the banking system.
 * It interacts with the TransactionRepository to perform CRUD operations on transactions,
 * and it communicates with the AccountService to update account balances.
 */
@Service
public class TransactionService {

    /**
     * The TransactionRepository to perform CRUD operations on transactions.
     */
    @Autowired
    private TransactionRepository transactionRepository;

    /**
     * The RestTemplate to make HTTP requests to the AccountService.
     */
    @Autowired
    private RestTemplate restTemplate;

    /**
     * The URL of the AccountService.
     */
    @Value("${account.service.url}")
    private String accountServiceUrl;

    /**
     * Creates a new transaction and updates the account balances.
     *
     * @param transaction The transaction to be created.
     * @return The created transaction.
     * @throws IllegalArgumentException If the fromAccount has insufficient funds.
     */
    public Transaction createTransaction(Transaction transaction) {
        Account fromAccount = getAccount(transaction.getFromAccountId());
        Account toAccount = getAccount(transaction.getToAccountId());

        if (fromAccount.getOpeningAmount().compareTo(transaction.getAmount()) < 0) {
            throw new IllegalArgumentException("Insufficient funds");
        }

        fromAccount.setOpeningAmount(fromAccount.getOpeningAmount().subtract(transaction.getAmount()));
        toAccount.setOpeningAmount(toAccount.getOpeningAmount().add(transaction.getAmount()));

        updateAccount(fromAccount);
        updateAccount(toAccount);

        transaction.setTimestamp(LocalDateTime.now());

        return transactionRepository.save(transaction);
    }

    /**
     * Retrieves all transactions.
     *
     * @return A list of all transactions.
     */
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    /**
     * Retrieves a transaction by its ID.
     *
     * @param id The ID of the transaction to retrieve.
     * @return An Optional containing the transaction if found, otherwise an empty Optional.
     */
    public Optional<Transaction> getTransactionById(Long id) {
        return transactionRepository.findById(id);
    }

    /**
     * Deletes a transaction by its ID.
     *
     * @param id The ID of the transaction to delete.
     */
    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }

    /**
     * Retrieves an account by its ID from the AccountService.
     *
     * @param accountId The ID of the account to retrieve.
     * @return The retrieved account.
     */
    private Account getAccount(Long accountId) {
        return restTemplate.getForObject(accountServiceUrl + "/accounts/" + accountId, Account.class);
    }

    /**
     * Updates an account in the AccountService.
     *
     * @param account The account to update.
     */
    private void updateAccount(Account account) {
        restTemplate.put(accountServiceUrl + "/accounts/" + account.getId(), account);
    }
}
