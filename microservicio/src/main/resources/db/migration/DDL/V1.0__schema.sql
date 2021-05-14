create table usuario (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 telefono varchar(45) not null,
 metodopago varchar (45) not null,
 primary key (id)
);

create table cita (
 id int(11) not null auto_increment,
 descripcion varchar(100) not null,
 fecha_inicio datetime  null,
 fecha_final datetime  null,
 valor varchar(45) not null,
 metodopago double not null,
 primary key (id)
);


