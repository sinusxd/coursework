CREATE TABLE user_ticket(
    user_id INTEGER,
    ticket_id INTEGER,
    PRIMARY KEY (user_id, ticket_id),
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (ticket_id) REFERENCES tickets(id)
);