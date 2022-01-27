# For Java 8, try this
# FROM openjdk:8-jdk-alpine

# For Java 11, try this
FROM adoptopenjdk/openjdk11:alpine-jre

# Refer to Maven build -> finalName
ARG JAR_FILE=target/springboot-backend-0.0.1-SNAPSHOT.jar

# cp target/spring-boot-web.jar /opt/app/app.jar
COPY ${JAR_FILE} springboot-backend-0.0.1-SNAPSHOT.jar

# java -jar /opt/app/app.jar
ENTRYPOINT ["java","-jar","springboot-backend-0.0.1-SNAPSHOT.jar"]

EXPOSE 8080
## sudo docker run -p 8080:8080 -t docker-spring-boot:1.0
## sudo docker run -p 80:8080 -t docker-spring-boot:1.0