drop database if exists contrader;
create database if not exists contrader;



create table contrader.users (
idUser int (50) NOT NULL auto_increment,
username varchar(50), 
password varchar(50),
firstname varchar(30),
lastname varchar(30),
dateofbirth  varchar(30),
cf varchar(20),
businessname varchar(20),
vat varchar(30),
municipality varchar(30),
cap varchar(10),
city varchar(30),
address varchar(30),
telephone varchar(30),
role varchar(10),
PRIMARY KEY (idUser)
);


insert into contrader.users (idUser,username, password,firstname,lastname,dateofbirth,cf,businessname,vat,municipality,cap,city,address,telephone,role) values (1,'pippo', 'paperino','Paolo','Rossi','04/10/1987','plorss87','manager','PL34987','Benevento','82100','Benevento','Via Contrader','1234','admin'),
																																						(2,'ciccio', 'bello','Francesco','Randi','05/11/1986','frcrnd','student','FR59687','Ariano Irpino','83031','Ariano Irpino','Via uiip','5678','local');
create table contrader.gomme (
idGomme int (50) not null auto_increment,
model varchar (50), 
manufacturer varchar(50), 
price float,
width float,
height float,
diameter float,
weight float,
speed varchar(3),
season varchar(10),
typevehicle varchar(30),
PRIMARY KEY (idGomme));

insert into contrader.gomme (idGomme,model, manufacturer, price,width,height,diameter,weight,speed,season,typevehicle) values (1,'Trelleborg-B50', 'Trelleborg', 321.13,225,45,17,19,'S','Invernale','auto');
insert into contrader.gomme (idGomme,model, manufacturer, price,width,height,diameter,weight,speed,season,typevehicle) values (2,'SuperG-876 ', 'Super Gomme', 213.176,190,55,17,15,'H','Estivi','moto');

create table contrader.vehicle(
idVehicle int(50) not null auto_increment,
brand varchar(20),
model varchar(30),
power varchar(10),
version varchar(10),
capacity varchar(10),
primary key (idVehicle));
insert into contrader.vehicle(idVehicle,brand,model,power,version,capacity) values(1,'Fiat','Punto','Benzina','Eco','2000cc');
insert into contrader.vehicle(idVehicle,brand,model,power,version,capacity) values(2,'Lancia','Delta','Benzina','V2','2500cc');

create table contrader.compatibility(
idVehicle int (50),
idGomme int (50),
foreign key (idVehicle) references contrader.vehicle(idVehicle),
foreign key (idGomme) references contrader.gomme (idGomme));

SELECT * from contrader.gomme WHERE manufacturer='Super Gomme' AND typevehicle='moto'




