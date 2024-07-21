# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-alpine

# Set the working directory in the container
WORKDIR /usr/src/app

# Copy the JAR file into the container at the working directory
COPY ./target/Jenkins-test-pipeline.jar .

# Expose the port that your Spring Boot application will run on
EXPOSE 8084

# Define the command to run your application
CMD ["java", "-jar", "Jenkins-test-pipeline.jar"]