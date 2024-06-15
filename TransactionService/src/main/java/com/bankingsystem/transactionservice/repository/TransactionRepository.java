package com.bankingsystem.transactionservice.repository;

import com.bankingsystem.transactionservice.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This interface represents a repository for managing {@link Transaction} entities.
 * It extends Spring Data JPA's {@link JpaRepository} interface, which provides
 * basic CRUD operations and additional query methods.
 *
 */
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    // No additional methods are required for this interface.
    // Spring Data JPA will automatically generate implementations for the defined methods.
}
