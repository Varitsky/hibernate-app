BEGIN;

DROP TABLE IF EXISTS employees_details CASCADE;
DROP TABLE IF EXISTS employees CASCADE;

DROP TABLE IF EXISTS simple_items CASCADE;
CREATE TABLE simple_items (id bigserial PRIMARY KEY, title VARCHAR(255), price int);
INSERT INTO simple_items (title, price) VALUES
('box', 10),
('sphere', 20),
('maul', 100),
('door2', 50),
('door3', 50),
('camera', 500);

DROP TABLE IF EXISTS homework_products CASCADE;
CREATE TABLE homework_products (id bigserial PRIMARY KEY, title VARCHAR(255), price int);
INSERT INTO homework_products (title, price) VALUES
('box2', 10),
('sphere2', 20),
('maul2', 100),
('door22', 50),
('door32', 50),
('camera2', 500);


DROP TABLE IF EXISTS books CASCADE;
DROP TABLE IF EXISTS readers CASCADE;
DROP TABLE IF EXISTS books_readers CASCADE;
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