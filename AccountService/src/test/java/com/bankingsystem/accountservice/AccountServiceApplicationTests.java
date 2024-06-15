package com.bankingsystem.accountservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

/**
 * This class is a test suite for the AccountServiceApplication.
 * It uses Spring Boot's testing framework to test the application in a controlled environment.
 * The test suite is annotated with @SpringBootTest to load the Spring Boot application context.
 * The @ActiveProfiles("test") annotation is used to specify that the "test" profile should be used for testing.
 *
 * The class contains a single test method, contextLoads(), which is annotated with @Test.
 * This method is used to test the loading of the application context.
 * If the application context loads successfully, the test method will pass.
 *
 */
@SpringBootTest
@ActiveProfiles("test")
class AccountServiceApplicationTests {

    /**
     * This test method is used to test the loading of the application context.
     * If the application context loads successfully, the test method will pass.
     *
     * @throws Exception if any exception occurs during the test
     */
    @Test
    void contextLoads() {
    }

}
