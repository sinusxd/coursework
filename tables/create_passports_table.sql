CREATE TABLE passports(
    id SERIAL PRIMARY KEY NOT NULL,
    last_name VARCHAR(255),
    first_name VARCHAR(255),
    second_name VARCHAR(255),
    age INTEGER
);