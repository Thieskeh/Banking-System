package com.bankingsystem.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * The main class of the API Gateway application.
 * This class is annotated with {@link SpringBootApplication} to enable Spring Boot auto-configuration.
 * It also includes {@link EnableDiscoveryClient} to enable service discovery using Spring Cloud.
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayApplication {

    /**
     * The main method to run the Spring Boot application.
     *
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }

}
