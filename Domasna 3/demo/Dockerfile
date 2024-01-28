#FROM maven:3.8.5-openjdk-17 AS builder
#
## Set the working directory inside the container
#WORKDIR /app
#
## Copy the project files
#COPY /src .
#
## Build the application using Maven
#RUN apt-get update && apt-get install -y maven
#
#
## Use an official OpenJDK runtime as the base image for the final image
#FROM openjdk:11-ea-9-jre-slim
#
## Set the working directory inside the container
#WORKDIR /app
#
## Copy the JAR file from the builder stage to the final image
#COPY --from=builder /app/target/your-app.jar .
#
## Specify the command to run on container start
#CMD ["java", "-jar", "your-app.jar"]
## The rest of your Dockerfile...
FROM maven:3.8.4-openjdk-11
WORKDIR /app
COPY . .
RUN mvn clean install

