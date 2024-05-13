CREATE TABLE users(
    id SERIAL PRIMARY KEY NOT NULL,
    username VARCHAR(255),
    email VARCHAR(255),
    password_hash VARCHAR(255),
    passport_id INTEGER,
    FOREIGN KEY (passport_id) REFERENCES passports(id)
);