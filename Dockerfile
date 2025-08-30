#build stage
FROM openjdk:17-jdk-alpine AS build
WORKDIR /app
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src
RUN ./mvnw clean package -DskipTests

#COPY target/api-docker-training-0.0.1-SNAPSHOT.jar /app/api-docker-training-0.0.1-SNAPSHOT.jar
#EXPOSE 8080
#ENTRYPOINT ["java", "-jar", "/app/api-docker-training-0.0.1-SNAPSHOT.jar"]

# Run stage
#COPY target/api-docker-training-0.0.1-SNAPSHOT.jar /app/api-docker-training-0.0.1-SNAPSHOT.jar
#EXPOSE 8080
#ENTRYPOINT ["java", "-jar", "/app/api-docker-training-0.0.1-SNAPSHOT.jar"]

FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/api-docker-training-0.0.1-SNAPSHOT.jar api-docker-training-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "api-docker-training-0.0.1-SNAPSHOT.jar"]