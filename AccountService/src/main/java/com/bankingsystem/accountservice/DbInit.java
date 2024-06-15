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

/**
 * This class is responsible for initializing the database with sample data.
 * It uses the Spring framework's PostConstruct annotation to ensure that the database population occurs only once,
 * when the application context is fully initialized.
 */
@Component
public class DbInit {

    /**
     * The AccountRepository interface is used to interact with the database.
     * It is autowired by Spring to provide an instance of the repository.
     */
    @Autowired
    private AccountRepository accountRepository;

    /**
     * The Logger instance is used to log information and errors during the database initialization process.
     */
    private final Logger log = LoggerFactory.getLogger(DbInit.class);

    /**
     * This method is called by Spring after the application context is fully initialized.
     * It populates the database with sample account data if the database is empty.
     */
    @PostConstruct
    public void init() {
        try {
            log.info("Populating database...");
            // Check if the database is already populated
            if (accountRepository.count() > 0) {
                log.info("Database is already populated");
                return;
            }

            // Use JavaFaker to generate random account data
            Faker faker = new Faker();
            for (int i = 0; i < 10; i++) {
                Account account = new Account();
                account.setLastname(faker.name().lastName());
                account.setEmail(account.getLastname().toLowerCase().replace(" ","_") + "@gmail.com");
                account.setOpeningAmount(BigDecimal.valueOf(faker.number().randomDouble(2, 10, 100000)));
                // Save the account to the database
                accountRepository.save(account);
            }
            System.out.println("Database populated successfully.");

        } catch (Exception e) {
            // Log any errors that occur during the database initialization process
            log.error("Error during database initialization", e);
        }
    }
}
