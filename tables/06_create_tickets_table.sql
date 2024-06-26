CREATE TABLE tickets(
    id SERIAL PRIMARY KEY NOT NULL,
    user_id INTEGER,
    flight_id INTEGER,
    seat_number VARCHAR(255),
    seat_class VARCHAR(255),
    price DOUBLE PRECISION,
    FOREIGN KEY (user_id) REFERENCES users(id)
);