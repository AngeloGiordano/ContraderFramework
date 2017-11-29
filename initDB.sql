drop database if exists contrader;
create database if not exists contrader;

use contrader;

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


insert into contrader.users (username, password) values ('pippo', 'paperino');
insert into contrader.users (username, password) values ('ciccio', 'bello');
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

create table contrader.vehicle(
idVehicle int(50) not null auto_increment,
brand varchar(20),
model varchar(30),
power varchar(10),
version varchar(10),
capacity varchar(10),
primary key (idVehicle));

create table contrader.compatibility(
idVehicle int (50),
idGomme int (50),
foreign key (idVehicle) references contrader.vehicle(idVehicle),
foreign key (idGomme) references contrader.gomme (idGomme));




insert into contrader.gomme (model, manufacturer, price) values ('Trelleborg-B50', 'Trelleborg', 321.13);
insert into contrader.gomme (model, manufacturer, price) values ('SuperG-876 ', 'Super Gomme', 213.176);

