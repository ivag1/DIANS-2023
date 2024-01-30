#FROM openjdk:17-jdk-alpine
#ARG JAR_FILE=target/*.jar
#COPY ./target/demo-0.0.1-SNAPSHOT.jar app.jar
#ENTRYPOINT ["java","-jar","/app.jar"]

#FROM eclipse-temurin:17-jdk-jammy AS build
#ENV HOME=/usr/app
#RUN mkdir -p $HOME
#WORKDIR $HOME
#ADD . $HOME
##RUN chmod +x $HOME/mvnw
#RUN --mount=type=cache,target=/root/.m2  ./mvnw -f $HOME/pom.xml clean package
##RUN --mount=type=cache,target=/root/.m2 ./mvnw -f /usr/app/pom.xml clean install

## Package stage
##
#FROM eclipse-temurin:17-jre-jammy
#ARG JAR_FILE=/usr/app/target/*.jar
#COPY --from=build $JAR_FILE /app/runner.jar
#EXPOSE 8080
#ENTRYPOINT java -jar /app/runner.jar

#FROM openjdk:11-jre-slim
#
#WORKDIR /demo
#
#COPY target/demo-0.0.1-SNAPSHOT.jar /demo/app.jar
#COPY src/main/resources/application.properties /app/application.properties
#
#CMD ["java", "-jar", "app.jar"]

FROM maven:3.9.6 AS build

WORKDIR /app

COPY src ./src

COPY pom.xml .

RUN mvn package

FROM amazoncorretto:21-alpine3.16-jdk

WORKDIR /app

COPY --from=build /app .

CMD ["java", "-jar", "./target/demo-0.0.1-SNAPSHOT.jar"]

EXPOSE 8081


