# Banking System Application

This project is a simple banking system implemented using Spring Boot and Docker. The system consists of multiple microservices:

- Eureka Service (Service Discovery)
- API Gateway (Gateway for accessing microservices)
- Account Service (Manages accounts)
- Transaction Service (Handles transactions)

## Table of Contents

- [Prerequisites](#prerequisites)
- [Setup](#setup)
- [Running the Application](#running-the-application)
- [Database Initialization](#database-initialization)
- [API Usage](#api-usage)


## Prerequisites

- Docker and Docker Compose
- Java 21+
- Maven

## Setup

1. Clone the repository:

    ```bash
    git clone https://github.com/Thieskeh/Banking-System.git
    cd banking-system
    ```

2. Build the services using Maven:

    ```bash
    mvn clean install
    ```

## Running the Application

1. Start the application using Docker Compose:

    ```bash
    docker-compose up --build
    ```

2. Access the Eureka Dashboard:

   Open your browser and go to `http://localhost:8761` to see the Eureka Dashboard with registered services.

## Database Initialization

The application includes a `DBInit` class that initializes the database with random account data using the Faker library. This class runs automatically at startup and populates the `Account` table with sample data.

### Sample Data

Upon starting the application, the `DBInit` class will create several accounts with randomly generated data. Here's an example of what the generated data might look like:

- Account 1:
    - Lastname: Smith
    - Email: john.smith@example.com
    - Opening Amount: 1000.00

- Account 2:
    - Lastname: Johnson
    - Email: emily.johnson@example.com
    - Opening Amount: 2000.00

These accounts are available for immediate use and can be accessed via the API Gateway.

## API Usage

All API requests should be routed through the API Gateway. Below are the primary endpoints.

### Postman

- Import file for postman: [Banking API.postman_collection.json](Banking%20API.postman_collection.json)


