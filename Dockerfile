FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY target/api-docker-training.jar /app/api-docker-training.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/api-docker-training.jar"]
