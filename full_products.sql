BEGIN;

DROP TABLE IF EXISTS home_work_products CASCADE;
CREATE TABLE home_work_products (id bigserial PRIMARY KEY, title VARCHAR(255), price int);
INSERT INTO home_work_products (title, price) VALUES
('tinydragon', 10),
('bigdragon', 20),
('snake', 100),
('lion', 50),
('cat', 500),
('tinycat', 500);

COMMIT;
