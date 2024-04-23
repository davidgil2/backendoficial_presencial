ALTER SESSION
SET
  CONTAINER = XEPDB1;

ALTER SESSION
SET
  CURRENT_SCHEMA = AIRLINE_ADMIN;

INSERT INTO
  AIRPLANE_MODEL (
    airplane_model,
    family,
    capacity,
    cargo_capacity,
    volume_capacity
  )
VALUES
  ('A320-200', 'Airbus', 180, 20000, 1000);

INSERT INTO
  AIRPLANE_MODEL (
    airplane_model,
    family,
    capacity,
    cargo_capacity,
    volume_capacity
  )
VALUES
  ('A320-300', 'Airbus', 277, 45000, 1000);

INSERT INTO
  AIRPLANE_MODEL (
    airplane_model,
    family,
    capacity,
    cargo_capacity,
    volume_capacity
  )
VALUES
  ('A330-300', 'Airbus', 277, 45000, 1000);

INSERT INTO
  AIRPORT (airport_code, name, type, city, country, runways)
VALUES
  (
    'MDE',
    'Jose Maria Cordova',
    1,
    'Medellin',
    'Colombia',
    2
  );

INSERT INTO
  AIRPORT (airport_code, name, type, city, country, runways)
VALUES
  ('BOG', 'El Dorado', 1, 'Bogota', 'Colombia', 3);

COMMIT;