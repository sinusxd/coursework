CREATE TABLE flights(
    id SERIAL PRIMARY KEY NOT NULL,
    airline_id INTEGER,
    departure_airport_id INTEGER,
    arrival_airport_id INTEGER,
    departure_date DATE,
    departure_time TIME,
    arrival_date DATE,
    arrival_time TIME,
    FOREIGN KEY (airline_id) REFERENCES airlines(id),
    FOREIGN KEY (departure_airport_id) REFERENCES airports(id),
    FOREIGN KEY (arrival_airport_id) REFERENCES airports(id)
)