# Use an official OpenJDK runtime as a parent image
FROM openjdk:21-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the project files into the container
COPY target/EurekaService-0.0.1-SNAPSHOT.jar eureka-service.jar

# Expose the port that the service runs on
EXPOSE 8761

# Command to run the application
ENTRYPOINT ["java", "-jar", "eureka-service.jar"]