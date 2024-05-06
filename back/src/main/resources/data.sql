-- Insertar SpecialDate 1
INSERT INTO special_date (id, date)
VALUES (1, '2024-05-03')
ON CONFLICT DO NOTHING;

-- Insertar SpecialDate 2
INSERT INTO special_date (id, date)
VALUES (2, '2024-06-15')
ON CONFLICT DO NOTHING;

-- Insertar SpecialDate 3
INSERT INTO special_date (id, date)
VALUES (3, '2024-07-20')
ON CONFLICT DO NOTHING;

-- Insertar productos

INSERT INTO products (id, name, description, stock, price, image)
VALUES (1, 'iPhone', '¡El iPhone 15 ya está aquí! Disfruta de una pantalla Super Retina XDR de 6.1, un sistema de cámara dual de 48MP, el potente chip A16 Bionic, batería de larga duración, conectividad 5G, Face ID e iOS 16. Resistente al agua y al polvo, con carga inalámbrica, doble SIM y mucho más. ¡No te pierdas lo último en tecnología!', 16, 999.99, '../assets/products/Apple-iPhone-15-lineup-hero-geo-230912_inline.jpg.large.jpg')
ON CONFLICT DO NOTHING;

INSERT INTO products (id, name, description, stock, price, image)
VALUES (2, 'Google Pixel', 'Captura fotos increíbles, disfruta de un rendimiento fluido, y mantén tu información segura con el Pixel 6 Pro. Su cámara triple avanzada, procesador Google Tensor personalizado, batería de larga duración y elegante diseño lo convierten en la mejor opción del mercado. ¡No te pierdas la oportunidad de tenerlo!', 5, 555.0, '../assets/products/images (2).jpg')
ON CONFLICT DO NOTHING;

INSERT INTO products (id, name, description, stock, price, image)
VALUES (3, 'Camisa', 'Camisa blanca', 5, 2.33, '/assets/products/images.jpg')
ON CONFLICT DO NOTHING;

INSERT INTO products (id, name, description, stock, price, image)
VALUES (4, 'Microsoft Surface', 'Descubre la versatilidad y potencia del Microsoft Surface en nuestra tienda online. El Surface es mucho más que una simple tableta o laptop: es un dispositivo 2 en 1 que se adapta a tus necesidades. Con una pantalla táctil de alta resolución y compatibilidad con Surface Pen, ofrece una experiencia interactiva y precisa para trabajar, estudiar o entretenerse. Equipado con procesadores potentes de Intel o AMD, garantiza un rendimiento fluido y eficiente, mientras que su diseño ligero y compacto lo hace perfecto para llevar a cualquier parte. Con conectividad avanzada, como puertos USB-C y LTE en algunos modelos, el Surface te mantiene conectado en todo momento. ¡Descubre una nueva forma de computación móvil con el Microsoft Surface!', 50, 1100.0, '../assets/products/61UGE9cZVlL._AC_SL1500_.jpg')
ON CONFLICT DO NOTHING;

INSERT INTO products (id, name, description, stock, price, image)
VALUES (5, 'Apple Watch', 'Elegante diseño, pantalla Retina siempre activa, monitoreo avanzado de salud y actividad física, notificaciones inteligentes, llamadas y mensajes en tu muñeca, Apple Pay para pagos rápidos, y una gran variedad de apps para personalizar tu experiencia. ¡El reloj inteligente perfecto para ti!', 5, 2.33, '../assets/products/apple-watches-smart-watch-wrist-watch-fire-boltt-noise-boat-spigen-crossbeats-500x500.webp')
ON CONFLICT DO NOTHING;

INSERT INTO products (id, name, description, stock, price, image)
VALUES (6, 'Zapatillas Adidas', 'Desde zapatillas para correr como las Ultraboost o NMD, hasta opciones para entrenar como las Supernova o Terrex, sin olvidar clásicos atemporales como las Stan Smith o Superstar. Adidas te ofrece una amplia gama de modelos, colores y tallas para que encuentres las zapatillas perfectas para tu estilo y necesidades. ¡No te pierdas la oportunidad de tener unas Adidas!', 500, 10.55, '../assets/products/images (1).jpg')
ON CONFLICT DO NOTHING;

INSERT INTO products (id, name, description, stock, price, image)
VALUES (7, 'Ray-Ban', 'Encuentra el modelo perfecto para ti entre aviadores clásicos, wayfarers versátiles, clubmasters sofisticados o rounds retro. Elige entre lentes de sol o de vista, todos con materiales duraderos y lentes de alta calidad que protegen tu visión. ¡No te pierdas la oportunidad de tener unos Ray-Ban!', 10, 33.00, '../assets/products/download.jpg')
ON CONFLICT DO NOTHING;

INSERT INTO products (id, name, stock, price)
VALUES (8, 'Producto sin imagen', 5, 2.15)
ON CONFLICT DO NOTHING;
-- **********************************************************


INSERT INTO users (username, password, type)
VALUES
  ('common@email.com', '$2a$10$Cf4n523B6JbOFOx1ic1GxeTTWvgaGHc2RZ8hLEvRKVPtB4KvUji2K', 'USER_COMMON'),
  ('vip@email.com', '$2a$10$spip6c9hUvIEKITkvKpCq.lrXg3qBN2JY9EGkwTvQsHoKoWNsFZ56', 'USER_VIP') ON CONFLICT (username) DO NOTHING;

