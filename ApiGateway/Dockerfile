# Use an official OpenJDK runtime as a parent image
FROM openjdk:21-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the project files into the container
COPY target/ApiGateway-0.0.1-SNAPSHOT.jar api-gateway.jar

# Expose the port that the service runs on
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "api-gateway.jar"]"/api-gateway.jar"]