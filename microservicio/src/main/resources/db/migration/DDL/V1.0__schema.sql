create table usuario (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 clave varchar(45) not null,
 fecha_creacion datetime null,
 primary key (id)
);

create table pago (
 id int(11) not null auto_increment,
 placa varchar(6) not null,
 tipo_vehiculo int(1) not null,
 valor_pago float not null,
 fecha_pago datetime null,
 primary key (id)
);