FROM maven:3.6.3-jdk-11-slim AS build
COPY . .
RUN mvn clean package -Dmaven.test.skip=true

FROM adoptopenjdk/openjdk11:alpine-jre
COPY target/springboot-backend-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
EXPOSE 8080
