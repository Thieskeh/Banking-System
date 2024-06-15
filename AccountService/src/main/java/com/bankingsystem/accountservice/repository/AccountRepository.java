package com.bankingsystem.accountservice.repository;

import com.bankingsystem.accountservice.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This interface represents a repository for managing {@link Account} entities.
 * It extends the Spring Data JPA {@link JpaRepository} interface, which provides
 * basic CRUD operations and additional query methods.
 *
 */
public interface AccountRepository extends JpaRepository<Account, Long> {
    // No additional methods are required for this interface.
    // Spring Data JPA will automatically generate implementations for the defined methods.
}