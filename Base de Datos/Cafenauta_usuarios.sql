DROP DATABASE IF EXISTS cafenauta_usuarios;
CREATE DATABASE cafenauta_usuarios;
USE cafenauta_usuarios;

CREATE TABLE tb_usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(20),
    apellido_Paterno VARCHAR(255),
    apellido_Materno VARCHAR(255),
    dni VARCHAR(255),
    telefono VARCHAR(255),
    direccion VARCHAR(255),
    email VARCHAR(50),
    password VARCHAR(255)
);


INSERT INTO tb_usuario (nombre, apellido_Paterno, apellido_Materno, dni, telefono, direccion, email, password)
VALUES 
('Javier', 'Zarate', 'Quicaño', '77197424', '978634290', 'Jiron Pachitea 354', 'javier@gmail.com', '$2a$10$49/JxKHLDZzg2JSzJzrJNuXSGfJiiIfXVGsB3.4PXZ.44vRRNavYy'),--  >javier
('Josue', 'Sedano', 'Mesias', '55987456', '987654322', 'Avenida Siempre Viva 456', 'josue@gmail.com', '$2a$10$Z/zK2tMj.9xMj2E3/1b8jeGNhprpwMF14gUtacj8Ioj1E0/wEY8Ny');--  >Josue

