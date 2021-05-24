create table cita (
 id int(11) not null auto_increment,
 descripcion varchar(100) not null,
 fecha_inicio datetime  null,
 fecha_final datetime  null,
 valor varchar(45) not null,
 metodo_pago varchar(45) not null,
 primary key (id)
);


insert into cita(descripcion, fecha_inicio, fecha_final, valor, metodo_pago) values('Descripcion', now(), now(), 666.0, 'Credito')