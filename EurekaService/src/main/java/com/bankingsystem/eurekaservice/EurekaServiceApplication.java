package com.bankingsystem.eurekaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * This is the main class of the Eureka Service Application.
 * It is a Spring Boot application that runs an Eureka Server.
 * Eureka Server is a discovery service used by Netflix OSS for service discovery.
 *
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServiceApplication {

    /**
     * The main method is the entry point of the application.
     * It starts the Spring Boot application and runs the Eureka Server.
     *
     * @param args Command line arguments. Not used in this application.
     */
    public static void main(String[] args) {
        SpringApplication.run(EurekaServiceApplication.class, args);
    }
}
