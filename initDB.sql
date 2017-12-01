drop database if exists contrader;
create database if not exists contrader;



create table contrader.users (
idUser int (50) not null auto_increment,
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
																																						(2,'ciccio', 'bello','Francesco','Randi','05/11/1986','frcrnd','student','FR59687','Ariano Irpino','83031','Ariano Irpino','Via uiip','5678','local'),
                                                                                                                                                        (3,'angel', 'uiip','Angelo','Giordano','05/11/1987','grdngl','developer','GR59687','Nocera Superiore','83015','Nocera Superiore','Via Russo','2801','local'),
                                                                                                                                                        (4,'admin','admin','Admin','Admin','00/01/2000','asdf','admin','admin123','PC','010101','0000','010101','RAM','admin');
 
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
quantity int (30),
PRIMARY KEY (idGomme));

insert into contrader.gomme (idGomme,model, manufacturer, price,width,height,diameter,weight,speed,season,typevehicle,quantity) values (1,'Trelleborg-B50', 'Trelleborg', 321.13,225,45,17,19,'S','Invernale','auto',3);
insert into contrader.gomme (idGomme,model, manufacturer, price,width,height,diameter,weight,speed,season,typevehicle,quantity) values (2,'SuperG-876 ', 'Super Gomme', 213.176,190,55,17,15,'H','Estivi','moto',5);
insert into contrader.gomme (idGomme,model, manufacturer, price,width,height,diameter,weight,speed,season,typevehicle,quantity) values (3,'Bridgestone R\150WT ', 'Bridgestone', 313.176,200,58,20,17,'L','Estivi','commerciale',6);
insert into contrader.gomme(idGomme,model,manufacturer,price,width,height,diameter,weight,speed,season,typevehicle,quantity) values(4,'Michelin Alpin 5','Michelin',74.50,185,65,15,88,'T','estive','auto',10);

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
insert into contrader.vehicle(idVehicle,brand,model,power,version,capacity) values(3,'Honda','RX50','Benzina','V3','500cc');
create table contrader.compatibility(
idVehicle int (50),
idGomme int (50),
foreign key (idVehicle) references contrader.vehicle(idVehicle),
foreign key (idGomme) references contrader.gomme (idGomme));






