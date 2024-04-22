
FROM ubuntu:latest AS build


RUN apt-get update && apt-get install -y openjdk-17-jdk


WORKDIR /app


COPY . .


RUN ./mvnw package


FROM openjdk:17-jdk-slim

WORKDIR /app


COPY --from=build /app/target/demo-1.jar app.jar


EXPOSE 8080


ENTRYPOINT ["java", "-jar", "app.jar"]