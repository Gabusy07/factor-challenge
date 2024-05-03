FROM openjdk:17-jdk-slim as builder

WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw  ./
COPY pom.xml ./

RUN ./mvnw clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r ./target/

#RUN ./mvnw dependency:go-offline

COPY src/ ./src

RUN ./mvnw clean package -DskipTests

FROM openjdk:17-jdk-slim

WORKDIR /ecommerce
RUN mkdir ./logs
COPY /target/ecommerce-0.0.1.jar .
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "ecommerce-0.0.1.jar"]