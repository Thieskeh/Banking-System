package com.bankingsystem.accountservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * The main class of the Account Service application.
 * This class is annotated with {@link SpringBootApplication} to enable Spring Boot auto-configuration,
 * component scanning, and other features.
 * It also includes {@link EnableDiscoveryClient} to enable service discovery using Spring Cloud.
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AccountServiceApplication {

    /**
     * The main method to run the Account Service application.
     *
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }
}
