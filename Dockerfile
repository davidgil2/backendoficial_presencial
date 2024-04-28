FROM maven:3.9.6-amazoncorretto-17 AS build


WORKDIR /app

COPY . /app

RUN mvn clean package -Dmaven.test.skip

FROM amazoncorretto:17-alpine-jdk

WORKDIR /app

COPY --from=build /app/target/airline-api-0.0.1-SNAPSHOT.jar /app/application.jar

EXPOSE 8080

ENV DATABASE_URL=" jdbc:oracle:thin:@localhost:1521/ORCLCDB"
ENV DATABASE_USERNAME="AIRLINE_ADMIN_B"
ENV DATABASE_PASSWORD="SITAS"

CMD ["java", "-jar", "application.jar"]





