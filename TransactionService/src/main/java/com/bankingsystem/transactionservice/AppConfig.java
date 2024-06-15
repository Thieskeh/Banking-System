package com.bankingsystem.transactionservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * This class is responsible for configuring the application's beans.
 * It provides a RestTemplate bean, which is a convenient utility for making HTTP requests.
 */
@Configuration
public class AppConfig {

    /**
     * This method creates and returns a new instance of RestTemplate.
     * RestTemplate is a powerful utility for making HTTP requests in Spring applications.
     *
     * @return a new instance of RestTemplate
     */
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
