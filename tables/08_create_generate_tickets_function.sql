CREATE OR REPLACE FUNCTION generate_tickets()
    RETURNS TRIGGER AS $$
DECLARE
    seat_price DOUBLE PRECISION;
    seat_class TEXT;
    row_number INTEGER;
    seat_letter TEXT;
    seat_number TEXT;
    i INTEGER;
    letters TEXT[] := ARRAY['A', 'B', 'C', 'D', 'E', 'F'];
BEGIN
    FOR row_number IN 1..25 LOOP
            -- Определение класса и цены в зависимости от номера ряда
            IF row_number BETWEEN 1 AND 5 THEN
                seat_class := 'BUSINESS';
                seat_price := 5000.00;
            ELSE
                seat_class := 'ECONOMY';
                seat_price := 3000.00;
            END IF;

            -- Генерация мест для каждой буквы в ряду
            FOREACH seat_letter IN ARRAY letters LOOP
                    seat_number := seat_letter || row_number::TEXT;
                    BEGIN
                        INSERT INTO tickets (user_id, flight_id, seat_number, seat_class, price)
                        VALUES (NULL, NEW.id, seat_number, seat_class, seat_price);
                    EXCEPTION WHEN OTHERS THEN
                        RAISE NOTICE 'Failed to insert ticket: %', SQLERRM;
                    END;
                END LOOP;
        END LOOP;

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;
