CREATE TABLE IF NOT EXISTS flight
(
    id          SERIAL PRIMARY KEY,
    name        VARCHAR(128) NOT NULL UNIQUE,
    destination VARCHAR(256) NOT NULL
);