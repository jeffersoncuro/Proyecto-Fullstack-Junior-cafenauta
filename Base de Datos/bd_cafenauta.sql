DROP DATABASE cafenauta;
CREATE DATABASE cafenauta;
USE cafenauta;

CREATE TABLE tb_distrito(
id_dis		bigint primary key auto_increment,
nom_dis		varchar(255)
);

INSERT INTO tb_distrito (nom_dis) VALUES
('Ancón'),
('Ate'),
('Barranco'),
('Breña'),
('Carabayllo'),
('Cercado de Lima'),
('Chaclacayo'),
('Chorrillos'),
('Cieneguilla'),
('Comas'),
('El Agustino'),
('Independencia'),
('Jesús María'),
('La Molina'),
('La Victoria'),
('Lince'),
('Los Olivos'),
('Lurigancho'),
('Lurín'),
('Magdalena del Mar'),
('Miraflores'),
('Pachacámac'),
('Pucusana'),
('Pueblo Libre'),
('Puente Piedra'),
('Punta Hermosa'),
('Punta Negra'),
('Rímac'),
('San Bartolo'),
('San Borja'),
('San Isidro'),
('San Juan de Lurigancho'),
('San Juan de Miraflores'),
('San Luis'),
('San Martín de Porres'),
('San Miguel'),
('Santa Anita'),
('Santa María del Mar'),
('Santa Rosa'),
('Santiago de Surco'),
('Surquillo'),
('Villa El Salvador'),
('Villa María del Triunfo');

CREATE TABLE tb_local(
id_local	bigint primary key auto_increment,
id_dis		bigint,
dir_local	varchar(200) not null,
tel_local	varchar(9),
email_local varchar(50),
horario_apertura	time not null,
horario_cierre		time not null,
`enable`			varchar(1),
foreign key (id_dis) references tb_distrito(id_dis)
);

INSERT INTO tb_local (id_local, id_dis, dir_local, tel_local, email_local, horario_apertura, horario_cierre, `enable`) VALUES
(1, 21, 'Av. José Larco 456', '987654321', 'local1@gmail.com', '09:00:00', '21:00:00', 'S'),
(2, 40, 'Av. Juan de Arona 789', '456123789', 'local2@gmail.com', '07:30:00', '20:30:00', 'S'),
(3, 3, 'Av. Bolognesi 321', '321654987', 'local3@gmail.com', '10:00:00', '23:00:00', 'S'),
(4, 31, 'Av. Caminos del Inca 654', '654789321', 'local4@gmail.com', '08:30:00', '19:30:00', 'N');

CREATE TABLE tb_reserva(
id_res		bigint primary key auto_increment,
id_local	bigint,
nom_res		varchar(25) not null,
ape_res		varchar(25) not null,
email_res	varchar(50) not null,
tel_res		varchar(9) not null,
fecha_reserva   date not null,
hora_reserva    time not null,
comensales		int	 not null,
`enable`		varchar(1),
foreign key (id_local) references tb_local(id_local)
);

INSERT INTO tb_reserva (id_local, nom_res, ape_res, email_res, tel_res, fecha_reserva, hora_reserva, comensales, `enable`) VALUES
(1, 'Carlos', 'Gomez', 'carlosgomez@gmail.com', '987654321', '2024-10-05', '12:30:00', 4, 'S'),
(2, 'María', 'Pérez', 'mariaperez@hotmail.com', '987321654', '2024-10-06', '14:00:00', 2, 'S'),
(3, 'Jorge', 'Ramírez', 'jorgeramirez@yahoo.com', '954123789', '2024-10-07', '19:00:00', 3, 'S'),
(4, 'Ana', 'Lopez', 'analopez@gmail.com', '921654987', '2024-10-08', '18:30:00', 5, 'S'),
(1, 'Luis', 'Fernandez', 'luisfernandez@hotmail.com', '987456321', '2024-10-09', '13:00:00', 6, 'S');