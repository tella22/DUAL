-- *********************************************
-- * Standard SQL generation                   
-- *--------------------------------------------
-- * DB-MAIN version: 10.0.3              
-- * Generator date: Aug 17 2017              
-- * Generation date: Fri Dec 15 19:21:42 2017 
-- * LUN file: C:\Users\usuario\Desktop\BBDD\ej1h5.lun 
-- * Schema: e1jh5 relational/1 
-- ********************************************* 


-- Database Section
-- ________________ 

create database e1jh5 relational;


-- DBSpace Section
-- _______________


-- Tables Section
-- _____________ 

create table come (
     num_matricula numeric(10) not null,
     fecha date not null,
     num_menu numeric(10) not null,
     constraint FKcom_nin_ID primary key (num_matricula));

create table contiene (
     num_menu numeric(10) not null,
     nombre char(10) not null,
     constraint ID_contiene_ID primary key (nombre, num_menu));

create table contiene_1 (
     C_i_nombre char(10) not null,
     nombre char(10) not null,
     constraint ID_contiene_1_ID primary key (C_i_nombre, nombre));

create table ingrediente (
     nombre char(10) not null,
     constraint ID_ingrediente_ID primary key (nombre));

create table matriculan (
     num_matricula numeric(10) not null,
     dni char(9) not null,
     coste_fijo numeric(5) not null,
     fecha_alta date not null,
     fecha_baja date not null,
     constraint ID_matriculan_ID primary key (num_matricula, dni, fecha_alta),
     constraint FKmat_nin_ID unique (num_matricula));

create table menu (
     num_menu numeric(10) not null,
     precio numeric(4) not null,
     constraint ID_menu_ID primary key (num_menu));

create table nino (
     num_matricula numeric(10) not null,
     nombre char(10) not null,
     fecha_nacimiento date not null,
     constraint ID_nino_ID primary key (num_matricula));

create table paga_por (
     num_matricula numeric(10) not null,
     cuenta_bancaria char(15) not null,
     dni char(9) not null,
     constraint FKpag_nin_ID primary key (num_matricula));

create table personas (
     dni char(9) not null,
     telefono numeric(9) not null,
     direccion char(20) not null,
     Nombre char(20) not null,
     constraint ID_personas_ID primary key (dni));

create table plato (
     nombre char(10) not null,
     constraint ID_plato_ID primary key (nombre));

create table recogen (
     num_matricula numeric(10) not null,
     dni char(9) not null,
     relacion char(15) not null,
     constraint ID_recogen_ID primary key (dni, num_matricula));

create table ser_alergico (
     nombre char(10) not null,
     num_matricula numeric(10) not null,
     constraint ID_ser_alergico_ID primary key (nombre, num_matricula));


-- Constraints Section
-- ___________________ 

alter table come add constraint FKcom_nin_FK
     foreign key (num_matricula)
     references nino;

alter table come add constraint FKcom_men_FK
     foreign key (num_menu)
     references menu;

alter table contiene add constraint FKcon_pla_1
     foreign key (nombre)
     references plato;

alter table contiene add constraint FKcon_men_FK
     foreign key (num_menu)
     references menu;

alter table contiene_1 add constraint FKcon_pla_FK
     foreign key (nombre)
     references plato;

alter table contiene_1 add constraint FKcon_ing
     foreign key (C_i_nombre)
     references ingrediente;

alter table matriculan add constraint FKmat_per_FK
     foreign key (dni)
     references personas;

alter table matriculan add constraint FKmat_nin_FK
     foreign key (num_matricula)
     references nino;

alter table menu add constraint ID_menu_CHK
     check(exists(select * from come
                  where come.num_menu = num_menu)); 

alter table menu add constraint ID_menu_CHK
     check(exists(select * from contiene
                  where contiene.num_menu = num_menu)); 

alter table nino add constraint ID_nino_CHK
     check(exists(select * from come
                  where come.num_matricula = num_matricula)); 

alter table nino add constraint ID_nino_CHK
     check(exists(select * from matriculan
                  where matriculan.num_matricula = num_matricula)); 

alter table nino add constraint ID_nino_CHK
     check(exists(select * from paga_por
                  where paga_por.num_matricula = num_matricula)); 

alter table nino add constraint ID_nino_CHK
     check(exists(select * from recogen
                  where recogen.num_matricula = num_matricula)); 

alter table paga_por add constraint FKpag_per_FK
     foreign key (dni)
     references personas;

alter table paga_por add constraint FKpag_nin_FK
     foreign key (num_matricula)
     references nino;

alter table personas add constraint ID_personas_CHK
     check(exists(select * from matriculan
                  where matriculan.dni = dni)); 

alter table personas add constraint ID_personas_CHK
     check(exists(select * from recogen
                  where recogen.dni = dni)); 

alter table plato add constraint ID_plato_CHK
     check(exists(select * from contiene_1
                  where contiene_1.nombre = nombre)); 

alter table plato add constraint ID_plato_CHK
     check(exists(select * from contiene
                  where contiene.nombre = nombre)); 

alter table recogen add constraint FKrec_per
     foreign key (dni)
     references personas;

alter table recogen add constraint FKrec_nin_FK
     foreign key (num_matricula)
     references nino;

alter table ser_alergico add constraint FKser_nin_FK
     foreign key (num_matricula)
     references nino;

alter table ser_alergico add constraint FKser_ing
     foreign key (nombre)
     references ingrediente;


-- Index Section
-- _____________ 

create unique index FKcom_nin_IND
     on come (num_matricula);

create index FKcom_men_IND
     on come (num_menu);

create unique index ID_contiene_IND
     on contiene (nombre, num_menu);

create index FKcon_men_IND
     on contiene (num_menu);

create unique index ID_contiene_1_IND
     on contiene_1 (C_i_nombre, nombre);

create index FKcon_pla_IND
     on contiene_1 (nombre);

create unique index ID_ingrediente_IND
     on ingrediente (nombre);

create unique index ID_matriculan_IND
     on matriculan (num_matricula, dni, fecha_alta);

create index FKmat_per_IND
     on matriculan (dni);

create unique index ID_menu_IND
     on menu (num_menu);

create unique index ID_nino_IND
     on nino (num_matricula);

create index FKpag_per_IND
     on paga_por (dni);

create unique index FKpag_nin_IND
     on paga_por (num_matricula);

create unique index ID_personas_IND
     on personas (dni);

create unique index ID_plato_IND
     on plato (nombre);

create unique index ID_recogen_IND
     on recogen (dni, num_matricula);

create index FKrec_nin_IND
     on recogen (num_matricula);

create unique index ID_ser_alergico_IND
     on ser_alergico (nombre, num_matricula);

create index FKser_nin_IND
     on ser_alergico (num_matricula);

