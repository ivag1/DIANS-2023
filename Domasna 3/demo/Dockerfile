FROM maven:3.8.4-openjdk-17 AS builder

# Set the working directory inside the container
WORKDIR /app

# Copy the project files
COPY . .

# Build the application using Maven
RUN mvn clean install

# Use the same Maven image as the base image for the runtime
FROM maven:3.8.4-openjdk-17

# Set the working directory inside the container
WORKDIR /app

# Copy only the JAR file from the builder stage
COPY --from=builder /app/target/your-app.jar .

# Specify the command to run on container start
CMD ["java", "-jar", "your-app.jar"]