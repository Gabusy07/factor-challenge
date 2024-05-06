FROM openjdk:17-jdk-slim as builder

WORKDIR /app

ENV DB_HOST postgres_db
ENV DB_PORT 5432
ENV NAME postgres
ENV DB_USERNAME postgres
ENV DB_PASSWORD postgres

COPY .mvn/ .mvn
COPY mvnw  ./
COPY pom.xml ./

RUN ./mvnw clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r ./target/

RUN ./mvnw dependency:go-offline

COPY src/ ./src

RUN ./mvnw clean package -DskipTests

FROM openjdk:17-jdk-slim

WORKDIR /ecommerce
#RUN mkdir ./logs
COPY /target/ecommerce-0.0.1.jar .
COPY src/main/resources/*.sql /docker-entrypoint-initdb.d/
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "ecommerce-0.0.1.jar"]