create database if not exists modulo5;

use modulo5;

create table if not exists usuarios(
id int primary key auto_increment,
nombre varchar(20) not null,
apellido varchar(20) not null,
correo varchar(50) not null,
contrasena varchar(20) not null,
saldo decimal(10,2) not null
);

INSERT INTO usuarios (nombre, apellido, correo, contrasena, saldo)
VALUES
  ('Juan', 'Perez', 'juan.perez@example.com', 'password1', 500000.00),
  ('Maria', 'Garcia', 'maria.garcia@example.com', 'password2', 250000.00),
  ('Pedro', 'Lopez', 'pedro.lopez@example.com', 'password3', 1000000.00),
  ('Ana', 'Martin', 'ana.martin@example.com', 'password4', 350000.00),
  ('Carlos', 'Gomez', 'carlos.gomez@example.com', 'password5', 700000.00),
  ('Sofia', 'Ruiz', 'sofia.ruiz@example.com', 'password6', 400000.00),
  ('Diego', 'Sanchez', 'diego.sanchez@example.com', 'password7', 600000.00),
  ('Andrea', 'Alvarez', 'andrea.alvarez@example.com', 'password8', 900000.00),
  ('Alejandro', 'Romero', 'alejandro.romero@example.comcorreo', 'password9', 800000.00),
  ('Laura', 'Flores', 'laura.flores@example.com', 'password10', 550000.00),
  ('David', 'Torres', 'david.torres@example.com', 'password11', 200000.00),
  ('Marta', 'Jimenez', 'marta.jimenez@example.com', 'password12', 150000.00),
  ('Javier', 'Navarro', 'javier.navarro@example.com', 'password13', 450000.00),
  ('Esther', 'Muñoz', 'esther.munoz@example.com', 'password14', 750000.00),
  ('Omar', 'Blanco', 'omar.blanco@example.com', 'password15', 300000.00),
  ('Jessica', 'Moreno', 'jessica.moreno@example.com', 'password16', 650000.00),
  ('Nicolas', 'Fernandez', 'nicolas.fernandez@example.com', 'password17', 950000.00),
  ('Paula', 'Garcia', 'paula.garcia@example.com', 'password18', 850000.00),
  ('Adrian', 'Lopez', 'adrian.lopez@example.com', 'password19', 500000.00),
  ('Sara', 'Martinez', 'sara.martinez@example.com', 'password20', 250000.00);


