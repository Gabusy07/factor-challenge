START TRANSACTION;

INSERT INTO products (name, description, stock, code, price, image)
VALUES ('Producto 1', 'Descripción del Producto 1', 10, 'CODE001', 25.0, 'imagen1.jpg');

INSERT INTO products (name, description, stock, code, price, image)
VALUES ('Producto 2', 'Descripción del Producto 2', 15, 'CODE002', 30.0, 'imagen2.jpg');

INSERT INTO products (name, description, stock, code, price, image)
VALUES ('Producto 3', 'Descripción del Producto 3', 20, 'CODE003', 35.0, 'imagen3.jpg');

COMMIT;

-- Insertar SpecialDate 1
INSERT INTO special_date (date)
VALUES ('2024-05-03');

-- Insertar SpecialDate 2
INSERT INTO special_date (date)
VALUES ('2024-06-15');

-- Insertar SpecialDate 3
INSERT INTO special_date (date)
VALUES ('2024-07-20');



INSERT INTO carts (total_price, is_active, initial_date, max_date_available, type, new_column_name)
VALUES (50.0, true, '2024-05-03 08:00:00', '2024-05-03 18:00:00', 'ONLINE', 'EXAMPLE_VALUE');

