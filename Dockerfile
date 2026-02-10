# Stage 1: Build the application
# CHANGED: Using a Maven image with Java 21 support
FROM maven:3.9.9-eclipse-temurin-21 AS build
COPY . .
RUN mvn clean package -DskipTests

# Stage 2: Run the application
# CHANGED: Using Java 21 for the runtime
FROM eclipse-temurin:21-jdk-alpine
COPY --from=build /target/*.jar demo.jar
EXPOSE 8885
ENTRYPOINT ["java","-jar","demo.jar"]