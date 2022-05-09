USE heb

CREATE TABLE IF NOT EXISTS customers (
    id INT AUTO_INCREMENT Primary KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    email VARCHAR(64) NOT NULL,
    address VARCHAR(120) NOT NUll,
    city VARCHAR(100) NOT NULL,
    state VARCHAR(2) NOT NULL,
    zip_code VARCHAR(16) NOT NULL

)