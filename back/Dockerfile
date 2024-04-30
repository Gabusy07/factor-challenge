FROM openjdk:17-jdk-slim as builder

FROM openjdk:17-jdk-slim

WORKDIR /app
RUN mkdir ./logs
ARG JAR_FILE=target/ecommerce-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} .
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "ecommerce-0.0.1-SNAPSHOT.jar"]