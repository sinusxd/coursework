CREATE OR REPLACE FUNCTION generate_tickets()
    RETURNS TRIGGER AS $$
DECLARE
    class_types TEXT[] := ARRAY['ECONOMY', 'BUSINESS']; -- Массив типов классов
    seat_price DOUBLE PRECISION; -- Переменная для цены
    seat_class TEXT; -- Переменная для класса места
    row_number INTEGER; -- Номер ряда
    seat_letter TEXT; -- Буква места
    seat_number TEXT; -- Полное обозначение места
    i INTEGER; -- Счетчик для внешнего цикла
    letters TEXT[] := ARRAY['A', 'B', 'C', 'D', 'E', 'F']; -- Массив букв мест
BEGIN
    -- Цикл по классам мест
    FOR i IN 1..ARRAY_LENGTH(class_types, 1) LOOP
            seat_class := class_types[i];
            -- Установка цены в зависимости от класса
            IF seat_class = 'ECONOMY' THEN
                seat_price := 3000.00; -- Примерная цена для эконом-класса
            ELSE
                seat_price := 5000.00; -- Примерная цена для бизнес-класса
            END IF;

            -- Генерация мест от A до C и от 1 до 25
            FOR row_number IN 1..25 LOOP
                    FOREACH seat_letter IN ARRAY letters LOOP
                            seat_number := seat_letter || row_number::TEXT;
                            -- Вставка билета в таблицу tickets
                            INSERT INTO tickets (user_id, flight_id, seat_number, seat_class, price)
                            VALUES (NULL, NEW.id, seat_number, seat_class, seat_price);
                        END LOOP;
                END LOOP;
        END LOOP;

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;
