package com.bankingsystem.apigateway;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

/**
 * This class is a test suite for the ApiGatewayApplication class.
 * It uses Spring Boot's testing framework to test the application in a controlled environment.
 * The test suite is annotated with @SpringBootTest to load the Spring Boot application context.
 * The @ActiveProfiles("test") annotation is used to specify that the "test" profile should be used during testing.
 */
@SpringBootTest
@ActiveProfiles("test")
class ApiGatewayApplicationTests {

    /**
     * This test method checks if the application context loads successfully.
     * It does not take any parameters and does not return any value.
     * If the application context loads successfully, the test will pass.
     * If any exceptions occur during the loading of the application context, the test will fail.
     */
    @Test
    void contextLoads() {
    }

}
