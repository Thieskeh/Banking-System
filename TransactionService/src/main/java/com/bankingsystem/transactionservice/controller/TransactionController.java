package com.bankingsystem.transactionservice.controller;

import com.bankingsystem.transactionservice.exception.ResourceNotFoundException;
import com.bankingsystem.transactionservice.model.Transaction;
import com.bankingsystem.transactionservice.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This class is responsible for handling HTTP requests related to transactions.
 * It uses the TransactionService to perform CRUD operations on transactions.
 */
@RestController
@RequestMapping("/transactions")
public class TransactionController {

    /**
     * Autowired instance of TransactionService.
     */
    @Autowired
    private TransactionService transactionService;

    /**
     * Creates a new transaction.
     *
     * @param transaction The transaction to be created.
     * @return ResponseEntity containing the created transaction.
     */
    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction) {
        Transaction savedTransaction = transactionService.createTransaction(transaction);
        return ResponseEntity.ok(savedTransaction);
    }

    /**
     * Retrieves all transactions.
     *
     * @return ResponseEntity containing a list of all transactions.
     */
    @GetMapping
    public ResponseEntity<List<Transaction>> getAllTransactions() {
        List<Transaction> transactions = transactionService.getAllTransactions();
        return ResponseEntity.ok(transactions);
    }

    /**
     * Retrieves a transaction by its ID.
     *
     * @param id The ID of the transaction to be retrieved.
     * @return ResponseEntity containing the requested transaction.
     * @throws ResourceNotFoundException If the transaction with the given ID is not found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Transaction> getTransactionById(@PathVariable Long id) {
        Transaction transaction = transactionService.getTransactionById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Transaction not found with id " + id));
        return ResponseEntity.ok(transaction);
    }

    /**
     * Deletes a transaction by its ID.
     *
     * @param id The ID of the transaction to be deleted.
     * @return ResponseEntity with no content (status 204).
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable Long id) {
        transactionService.deleteTransaction(id);
        return ResponseEntity.noContent().build();
    }
}
