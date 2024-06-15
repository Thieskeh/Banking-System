package com.bankingsystem.accountservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * This class represents a bank account.
 * It is annotated with @Entity to indicate that it will be persisted in a database.
 */
@Entity
public class Account {
    /**
     * The unique identifier of the account.
     * It is annotated with @Id to indicate that it is the primary key.
     * It is also annotated with @GeneratedValue to indicate that the value will be generated automatically.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * The last name of the account holder.
     */
    private String lastname;

    /**
     * The email of the account holder.
     */
    private String email;

    /**
     * The opening amount of the account.
     */
    private BigDecimal openingAmount;

    // Getters and Setters

    /**
     * Returns the unique identifier of the account.
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the account.
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Returns the last name of the account holder.
     * @return the lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Sets the last name of the account holder.
     * @param lastname the lastname to set
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * Returns the email of the account holder.
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of the account holder.
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns the opening amount of the account.
     * @return the openingAmount
     */
    public BigDecimal getOpeningAmount() {
        return openingAmount;
    }

    /**
     * Sets the opening amount of the account.
     * @param openingAmount the openingAmount to set
     */
    public void setOpeningAmount(BigDecimal openingAmount) {
        this.openingAmount = openingAmount;
    }

    // Overridden methods

    /**
     * Compares this object with the specified object for equality.
     * @param o the object to compare with this object
     * @return true if the objects are the same; false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(id, account.id) && Objects.equals(lastname, account.lastname) && Objects.equals(email, account.email) && Objects.equals(openingAmount, account.openingAmount);
    }

    /**
     * Returns a hash code value for the object.
     * @return a hash code value for this object
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, lastname, email, openingAmount);
    }

    /**
     * Returns a string representation of the object.
     * @return a string representation of this object
     */
    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", openingAmount=" + openingAmount +
                '}';
    }
}
