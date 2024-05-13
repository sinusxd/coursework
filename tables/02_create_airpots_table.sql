CREATE TABLE airports(
    id SERIAL PRIMARY KEY NOT NULL,
    airport_code VARCHAR(255),
    airport_name VARCHAR(255),
    city VARCHAR(255),
    country VARCHAR(255)
);