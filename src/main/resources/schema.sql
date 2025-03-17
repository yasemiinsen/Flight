CREATE TABLE airport (
                         airport_id INT PRIMARY KEY AUTO_INCREMENT,
                         airport_code VARCHAR(10) NOT NULL,
                         airport_name VARCHAR(100) NOT NULL,
                         city VARCHAR(100) NOT NULL,
                         country VARCHAR(100) NOT NULL
);

CREATE TABLE airline (
                         airline_id INT PRIMARY KEY AUTO_INCREMENT,
                         airline_code VARCHAR(10) NOT NULL,
                         airline_name VARCHAR(100) NOT NULL
);

CREATE TABLE flight (
                        flight_id INT PRIMARY KEY AUTO_INCREMENT,
                        flight_number VARCHAR(10) NOT NULL,
                        departure_time DATETIME NOT NULL,
                        arrival_time DATETIME NOT NULL,
                        airline_id INT,
                        departure_airport_id INT,
                        arrival_airport_id INT,
                        FOREIGN KEY (airline_id) REFERENCES airlines(airline_id),
                        FOREIGN KEY (departure_airport_id) REFERENCES airports(airport_id),
                        FOREIGN KEY (arrival_airport_id) REFERENCES airports(airport_id)
);