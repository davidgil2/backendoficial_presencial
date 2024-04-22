ALTER SESSION
SET
  CONTAINER = XEPDB1;

ALTER SESSION
SET
  CURRENT_SCHEMA = AIRLINE_ADMIN;

CREATE TABLE
  FLIGHT (
    flight_id NUMBER GENERATED BY DEFAULT AS IDENTITY (
      START
      WITH
        1 INCREMENT BY 1
    ) PRIMARY KEY,
    flight_number VARCHAR2 (6) NOT NULL,
    base_price NUMBER (10, 2) NOT NULL,
    tax_percent NUMBER (5, 2) NOT NULL,
    surcharge NUMBER (10, 2) NOT NULL
  );

CREATE TABLE
  AIRPLANE_MODEL (
    airplane_model VARCHAR2 (15) PRIMARY KEY,
    family VARCHAR2 (15) NOT NULL,
    capacity NUMBER (3) NOT NULL,
    cargo_capacity NUMBER (10, 2)
  );

CREATE TABLE
  AIRPORT (
    airport_code VARCHAR2 (3) PRIMARY KEY,
    name VARCHAR2 (80) NOT NULL,
    type VARCHAR2 (20) NOT NULL,
    city VARCHAR2 (80) NOT NULL,
    country VARCHAR2 (30) NOT NULL,
    runways NUMBER (2) NOT NULL
  );

CREATE TABLE
  SCALE (
    scale_id NUMBER GENERATED BY DEFAULT AS IDENTITY (
      START
      WITH
        1 INCREMENT BY 1
    ) PRIMARY KEY,
    flight_id NUMBER REFERENCES Flight (flight_id) ON DELETE CASCADE,
    airplane_model VARCHAR2 (15) REFERENCES AirplaneModel (airplane_model),
    origin_airport VARCHAR2 (3) NOT NULL REFERENCES Airport (airport_code),
    destination_airport VARCHAR2 (3) NOT NULL REFERENCES Airport (airport_code),
    departure_date TIMESTAMP NOT NULL,
    arrival_date TIMESTAMP NOT NULL
  );

CREATE TABLE
  EMPLOYEE (
    employee_id NUMBER GENERATED BY DEFAULT AS IDENTITY (
      START
      WITH
        1 INCREMENT BY 1
    ) PRIMARY KEY,
    name VARCHAR2 (80) NOT NULL,
    job_title VARCHAR2 (30) NOT NULL
  );

CREATE TABLE
  FLIGHT_CREW (
    flight_crew_id NUMBER GENERATED BY DEFAULT AS IDENTITY (
      START
      WITH
        1 INCREMENT BY 1
    ) PRIMARY KEY,
    flight_id NUMBER REFERENCES Flight (flight_id) ON DELETE CASCADE,
    employee_id NUMBER REFERENCES Employee (employee_id),
    flight_role VARCHAR2 (20) NOT NULL
  );

COMMIT;