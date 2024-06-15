package com.bankingsystem.transactionservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * This class represents a banking transaction.
 * It is annotated with {@link Entity} to indicate that it will be persisted in the database.
 */
@Entity
public class Transaction {

    /**
     * The unique identifier of the transaction.
     * It is annotated with {@link Id} to indicate that it is the primary key.
     * It is also annotated with {@link GeneratedValue} to indicate that the value will be generated automatically.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * The identifier of the account from which the transaction is made.
     */
    private Long fromAccountId;

    /**
     * The identifier of the account to which the transaction is made.
     */
    private Long toAccountId;

    /**
     * The timestamp of the transaction.
     */
    private LocalDateTime timestamp;

    /**
     * The amount of the transaction.
     */
    private BigDecimal amount;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFromAccountId() {
        return fromAccountId;
    }

    public void setFromAccountId(Long fromAccountId) {
        this.fromAccountId = fromAccountId;
    }

    public Long getToAccountId() {
        return toAccountId;
    }

    public void setToAccountId(Long toAccountId) {
        this.toAccountId = toAccountId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    // Override methods

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(id, that.id) && Objects.equals(fromAccountId, that.fromAccountId) && Objects.equals(toAccountId, that.toAccountId) && Objects.equals(timestamp, that.timestamp) && Objects.equals(amount, that.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fromAccountId, toAccountId, timestamp, amount);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", fromAccountId=" + fromAccountId +
                ", toAccountId=" + toAccountId +
                ", timestamp=" + timestamp +
                ", amount=" + amount +
                '}';
    }
}
