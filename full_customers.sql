BEGIN;

DROP TABLE IF EXISTS employees_details CASCADE;
DROP TABLE IF EXISTS employees CASCADE;
DROP TABLE IF EXISTS simple_items CASCADE;
DROP TABLE IF EXISTS homework_products CASCADE;

DROP TABLE IF EXISTS homeworkproducts CASCADE;
CREATE TABLE homeworkproducts (id bigserial PRIMARY KEY, title VARCHAR(255), price int);
INSERT INTO homeworkproducts (title, price) VALUES
('box2', 10),
('sphere2', 20),
('door333333333332', 550),
('maul2', 100),
('door22', 50),
('door32', 50),
('camera2', 500);


DROP TABLE IF EXISTS customers CASCADE;
CREATE TABLE customers (id bigserial PRIMARY KEY, name VARCHAR(255));
INSERT INTO customers (name) VALUES
('Alexander'),
('Dmitry'),
('Bob');

DROP TABLE IF EXISTS homeworkproducts_customers CASCADE;
CREATE TABLE homeworkproducts_customers (product_id bigint, customer_id bigint, FOREIGN KEY (product_id) REFERENCES homeworkproducts (id), FOREIGN KEY (customer_id) REFERENCES customers (id));
INSERT INTO homeworkproducts_customers (product_id, customer_id) VALUES
(1, 1),
(2, 1),
(3, 1),
(4, 1),
(5, 1),
(6, 1),
(7, 1),
(8, 1),
(9, 1),
(10, 1),
(1, 2),
(2, 2);

DROP TABLE IF EXISTS universities CASCADE;
DROP TABLE IF EXISTS students CASCADE;
DROP TABLE IF EXISTS validation_beans CASCADE;
DROP TABLE IF EXISTS items CASCADE;
DROP TABLE IF EXISTS passports CASCADE;
DROP TABLE IF EXISTS citizens CASCADE;
DROP TABLE IF EXISTS locking_items CASCADE;
DROP TABLE IF EXISTS alive_beans CASCADE;
DROP TABLE IF EXISTS bottomless_boxes CASCADE;
DROP TABLE IF EXISTS things CASCADE;
DROP TABLE IF EXISTS simple_entities CASCADE;
DROP TABLE IF EXISTS orders CASCADE;
DROP TABLE IF EXISTS products CASCADE;
DROP TABLE IF EXISTS home_work_products CASCADE;

COMMIT;