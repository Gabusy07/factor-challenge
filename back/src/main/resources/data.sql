-- Insertar SpecialDate 1
INSERT INTO special_date (date)
VALUES ('2024-05-03');

-- Insertar SpecialDate 2
INSERT INTO special_date (date)
VALUES ('2024-06-15');

-- Insertar SpecialDate 3
INSERT INTO special_date (date)
VALUES ('2024-07-20');


INSERT INTO products (name, description, stock, price, image)
VALUES ('Iphone', 'smartphone', 16, 999.99, 'URL_de_la_imagen');

INSERT INTO products (name, description, stock, price, image)
VALUES ('smartwatch', 'reloj inteligente', 5, 55555550.0, 'URL_de_la_imagen');

INSERT INTO products (name, description, stock, price, image)
VALUES ('camisa', 'camisa blanca ...', 5, 2.33, 'URL_de_la_imagen');

INSERT INTO users (username, password, type)
VALUES
  ('common02@email.com', '$2a$10$Cf4n523B6JbOFOx1ic1GxeTTWvgaGHc2RZ8hLEvRKVPtB4KvUji2K', 'USER_COMMON'),
  ('vip02@email.com', '$2a$10$spip6c9hUvIEKITkvKpCq.lrXg3qBN2JY9EGkwTvQsHoKoWNsFZ56', 'USER_VIP') ON CONFLICT (username) DO NOTHING;

