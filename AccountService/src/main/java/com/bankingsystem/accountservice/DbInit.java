package com.bankingsystem.accountservice;

import com.bankingsystem.accountservice.model.Account;
import com.bankingsystem.accountservice.repository.AccountRepository;
import com.github.javafaker.Faker;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DbInit {

    @Autowired
    private AccountRepository accountRepository;

    private final Logger log = LoggerFactory.getLogger(DbInit.class);

    @PostConstruct
    public void init() {
        try {
            log.info("Populating database...");
            if (accountRepository.count() > 0) {
                log.info("Database is already populated");
                return;
            }

            Faker faker = new Faker();
            for (int i = 0; i < 10; i++) {
                Account account = new Account();
                account.setLastname(faker.dragonBall().character());
                account.setEmail(account.getLastname().toLowerCase() + "@gmail.com");
                account.setOpeningAmount(BigDecimal.valueOf(faker.number().randomDouble(2, 10, 100000)));
                accountRepository.save(account);
            }
            System.out.println("Database populated successfully.");

        } catch (
                Exception e) {
            log.error("Error during database initialization", e);
        }
    }
}
