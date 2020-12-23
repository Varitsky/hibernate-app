BEGIN;

DROP TABLE IF EXISTS products CASCADE;
CREATE TABLE products (id bigserial PRIMARY KEY, title VARCHAR(255), price int);
INSERT INTO products (title, price) VALUES
('box', 10),
('sphere', 20),
('door', 550),
('egg', 100),
('thor', 50),
('pencil', 50),
('mirror', 100),
('book', 50),
('product', 50),
('customer', 500);


DROP TABLE IF EXISTS customers CASCADE;
CREATE TABLE customers (id bigserial PRIMARY KEY, name VARCHAR(255));
INSERT INTO customers (name) VALUES
('Alexander'),
('Dmitry'),
('Bob');


DROP TABLE IF EXISTS orders CASCADE;
CREATE TABLE orders (product_id bigint, customer_id bigint, FOREIGN KEY (product_id) REFERENCES products (id), FOREIGN KEY (customer_id) REFERENCES customers (id));
INSERT INTO orders (product_id, customer_id) VALUES
(1, 1),
(2, 1),
(3, 1),
(4, 1),
(5, 1),
(5, 2),
(6, 1),
(7, 1),
(8, 1),
(9, 1),
(10, 1),
(1, 2),
(2, 2),
(5, 3),
(6, 3),
(7, 3);

COMMIT;