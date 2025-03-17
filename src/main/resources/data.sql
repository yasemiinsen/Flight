INSERT INTO airports (airport_code, airport_name, city, country) VALUES ('JFK', 'John F. Kennedy International Airport', 'New York', 'USA');
INSERT INTO airports (airport_code, airport_name, city, country) VALUES ('LAX', 'Los Angeles International Airport', 'Los Angeles', 'USA');
INSERT INTO airports (airport_code, airport_name, city, country) VALUES ('ORD', 'O'Hare International Airport', 'Chicago', 'USA');


INSERT INTO airline (airline_code, airline_name) VALUES ('AA', 'American Airlines');
INSERT INTO airline (airline_code, airline_name) VALUES ('DL', 'Delta Airlines');
INSERT INTO airline (airline_code, airline_name) VALUES ('UA', 'United Airlines');

 
INSERT INTO flight (flight_number, departure_time, arrival_time, airline_id, departure_airport_id, arrival_airport_id) VALUES ('FL101', '2025-03-01 10:00:00', '2025-03-01 12:30:00', 1, 1, 2);
INSERT INTO flight (flight_number, departure_time, arrival_time, airline_id, departure_airport_id, arrival_airport_id) VALUES ('FL202', '2025-03-01 14:00:00', '2025-03-01 16:00:00', 2, 2, 3);
INSERT INTO flight (flight_number, departure_time, arrival_time, airline_id, departure_airport_id, arrival_airport_id) VALUES ('FL303', '2025-03-02 09:00:00', '2025-03-02 11:00:00', 3, 3, 1);
INSERT INTO flight (flight_number, departure_time, arrival_time, airline_id, departure_airport_id, arrival_airport_id) VALUES ('FL404', '2025-03-02 15:15:00', '2025-03-02 17:45:00', 1, 1, 3);
INSERT INTO flight (flight_number, departure_time, arrival_time, airline_id, departure_airport_id, arrival_airport_id) VALUES ('FL505', '2025-03-03 08:30:00', '2025-03-03 10:00:00', 2, 2, 1);