/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  juang
 * Created: 25-11-2018
 */


CREATE database SOLEMNE3;
USE SOLEMNE3;

CREATE TABLE TIPO_PRODUCTO(
	DBID_TIPO_PRODUCTO INT(11) unsigned AUTO_INCREMENT PRIMARY KEY,
	NOMBRE varchar(50),
	IVA INT
);

create table PRODUCTOS(
	DBID_PRODUCTO INT(11) unsigned auto_increment primary key,
	NOMBRE varchar(255),
	ID_TIPO varchar(255) ,
	CANTIDAD INT(11),
	CANTIDAD_MINIMA INT(11),
	PRECIO_BRUTO INT(11),
	PRECIO_NETO INT(11)
	
	-- CONSTRAINT FK_PRODUCTO_TIPO FOREIGN KEY (ID_TIPO) REFERENCES TIPO_PRODUCTO(DBID_TIPO_PRODUCTO)
);

/*
create table CAJA(
	DBID_CAJA INT(11) unsigned auto_increment primary key,
	CODIGO_CAJA VARCHAR(100),
	FLUJO_INICIAL INT(11),
	FLUJO_INGRESO INT(11),
	FLUJO_SALIDA INT(11)
	
);
*/
create table VENTA(
	DBID_VENTA INT(11) unsigned auto_increment primary key,
	ID_PRODUCTO varchar(255), 
	ID_CAJA INT(11) unsigned,
	CANTIDAD INT(11),
	PRECIO_FINAL INT(11)
	-- CONSTRAINT FK_VENTA_PRODUCTO FOREIGN KEY (ID_PRODUCTO) REFERENCES PRODUCTOS(DBID_PRODUCTO),
	-- CONSTRAINT FK_VENTA_CAJA FOREIGN KEY (ID_CAJA) REFERENCES CAJA(DBID_CAJA)
		
);


insert into TIPO_PRODUCTO (NOMBRE,IVA) VALUES('Papeleria',16);
insert into TIPO_PRODUCTO (NOMBRE,IVA) VALUES('Supermercado',4);
insert into TIPO_PRODUCTO (NOMBRE,IVA) VALUES('Drogueria',12);
