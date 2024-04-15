FROM maven:3.9.6-amazoncorretto-21 AS build

WORKDIR /app

COPY . /app

RUN mvn clean package -Dmaven.test.skip

FROM amazoncorretto:21-alpine-jdk

WORKDIR /app

COPY --from=build /app/target/airline-api-0.0.1-SNAPSHOT.jar /app/application.jar

EXPOSE 8080

CMD ["java", "-jar", "application.jar"]