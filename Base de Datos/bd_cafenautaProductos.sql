DROP DATABASE IF EXISTS cafenauta_productos;
CREATE DATABASE cafenauta_productos;
USE cafenauta_productos;

CREATE TABLE categoria (
    id_categoria INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    descripcion VARCHAR(255) DEFAULT NULL
);

CREATE TABLE producto (
    id_producto INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion VARCHAR(255) DEFAULT NULL,
    precio DECIMAL(10, 2) NOT NULL,
    id_categoria INT,
    enable	varchar(1),
    FOREIGN KEY (id_categoria) REFERENCES categoria(id_categoria)
);
select * from producto;
INSERT INTO categoria (nombre, descripcion) VALUES 
('Cafés Clásicos', 'Café negro, espresso, y otras preparaciones tradicionales de café'),
('Cafés Especiales', 'Bebidas con base de café como cappuccino, latte, y macchiato'),
('Tés e Infusiones', 'Variedad de tés y tisanas calientes o frías'),
('Bebidas Frías', 'Frappés, jugos naturales y limonadas'),
('Bebidas con Leche', 'Lácteos como chocolate caliente y bebidas con leche vegetal'),
('Panadería', 'Croissants, muffins, y otros panes artesanales'),
('Postres y Repostería', 'Tartas, brownies, y otros dulces para acompañar'),
('Sandwiches y Bocadillos', 'Opciones de comida rápida como sandwiches y wraps'),
('Ensaladas', 'Ensaladas frescas para opciones más ligeras'),
('Snacks y Aperitivos', 'Galletas, frutos secos, y otros aperitivos para picar');

INSERT INTO producto (nombre, descripcion, precio, id_categoria, enable) VALUES 
('Café Americano', 'Café negro caliente', 2.50, 1, 'N'),
('Capuccino', 'Café con leche espumosa', 3.50, 1, 'S'),
('Cheesecake de Frutos Rojos', 'Pastel de queso con frutos rojos', 4.00, 2, 'S'),
('Smoothie de Fresa', 'Batido de fresa con hielo', 3.00, 3, 'N');
