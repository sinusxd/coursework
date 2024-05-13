CREATE TRIGGER trigger_generate_tickets
    AFTER INSERT ON flights
    FOR EACH ROW
EXECUTE FUNCTION generate_tickets();
