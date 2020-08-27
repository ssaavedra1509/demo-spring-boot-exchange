DROP TABLE IF EXISTS currency_exchange;

CREATE TABLE currency_exchange (
id INT AUTO_INCREMENT PRIMARY KEY,
source_currency VARCHAR(3) NOT NULL,
target_currency VARCHAR(3) NOT NULL,
change DECIMAL(10,2) NOT NULL
);

INSERT INTO currency_exchange (source_currency, target_currency, change) VALUES
('PEN', 'USD', 3.35),
('USD', 'PEN', 3.33),
('PEN', 'EUR', 4.83),
('EUR', 'PEN', 4.3),
('USD', 'EUR', 0.85);