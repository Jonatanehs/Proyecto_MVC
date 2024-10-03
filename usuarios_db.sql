create database usuarios_db;

use usuarios_db;

create table usuario(
Id_user int auto_increment not null primary key,
Nombre varchar(50),
Nombre_Usuario varchar(50) not null,
Correo varchar(100) not null,
Contrasenia varchar(100) not null,
Tipo_Usuario enum('usuario', 'admin') default 'usuario'
);

insert into usuario (Nombre, Nombre_Usuario, Correo, Contrasenia, Tipo_Usuario) values('Administrador', 'admin', 'admin@gmail.com', 'admin123', 'admin');

create table contenido (
    Id_contenido int auto_increment primary key,
    Titulo varchar(255) not null,
    Descripcion text,
    Autor varchar(100),
    Url varchar(255),
    Fecha_publicacion date,
    Tipo_contenido enum('articulo', 'video', 'recomendacion') default 'articulo',
    Contenido_detalle text,
    Categoria varchar(100), 
    Imagen varchar(255) 
);

describe usuario;
describe contenido;

select * from usuario;


