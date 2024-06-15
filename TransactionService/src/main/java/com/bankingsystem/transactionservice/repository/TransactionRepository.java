package com.bankingsystem.transactionservice.repository;

import com.bankingsystem.transactionservice.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {}
