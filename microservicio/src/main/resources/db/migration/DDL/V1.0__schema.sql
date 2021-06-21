create table cita (
 id int(11) not null auto_increment,
 descripcion varchar(100) not null,
 fecha_inicio datetime  null,
 fecha_final datetime  null,
 valor double not null,
 id_trabajador int(11) not null,
 primary key (id)
);

create table trabajador (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 telefono varchar(45) not null,
 metodo_pago varchar (45) not null,
 primary key (id)
);

insert into trabajador(nombre, telefono, metodo_pago) values ('Emanuel Sierra', '32077828834', 'crédito');



