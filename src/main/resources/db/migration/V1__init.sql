CREATE TABLE IF NOT EXISTS device (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    location VARCHAR(100) NOT NULL
    );

CREATE TABLE IF NOT EXISTS temperature (
    id SERIAL PRIMARY KEY,
    date_hour TIMESTAMP NOT NULL,
    humidity_value DECIMAL(10,2) NOT NULL,
    device_id INT,
    FOREIGN KEY (device_id) REFERENCES device(id)
    );
