create table cita (
 id int(11) not null auto_increment,
 descripcion varchar(100) not null,
 fecha_inicio datetime  null,
 fecha_final datetime  null,
 valor varchar(45) not null,
 id_usuario varchar(45) not null,
 primary key (id)
);

create table usuario (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 telefono varchar(45) not null,
 metodo_pago varchar (45) not null,
 primary key (id)
);

insert into usuario(nombre, telefono, metodo_pago) values ('Ema', '2122', 'credito');



