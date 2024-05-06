CREATE TABLE passports(
    id SERIAL PRIMARY KEY NOT NULL,
    user_id INTEGER,
    last_name VARCHAR(255),
    first_name VARCHAR(255),
    second_name VARCHAR(255),
    age INTEGER,
    FOREIGN KEY (user_id) REFERENCES users(id)
);