CREATE TABLE tickets(
    id SERIAL PRIMARY KEY NOT NULL,
    flight_id INTEGER,
    seat_number VARCHAR(255),
    class VARCHAR(255)
);