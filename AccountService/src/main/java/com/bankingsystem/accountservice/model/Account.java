package com.bankingsystem.accountservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String lastname;
    private String email;
    private BigDecimal openingAmount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getOpeningAmount() {
        return openingAmount;
    }

    public void setOpeningAmount(BigDecimal openingAmount) {
        this.openingAmount = openingAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(id, account.id) && Objects.equals(lastname, account.lastname) && Objects.equals(email, account.email) && Objects.equals(openingAmount, account.openingAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lastname, email, openingAmount);
    }

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
