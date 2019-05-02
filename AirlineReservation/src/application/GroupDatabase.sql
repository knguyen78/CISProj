create table registration(
customerID INT Auto_Increment,
firstname varchar(50) ,
lastname varchar(50),
address varchar(50),
zip numeric(5),
state varchar(2),
username varchar(30),
pword varchar(30),
email varchar(30),
SSN numeric (9),
securityQuestion varchar(100),
securityAnswer varchar(100),
isAdmin boolean,
primary key (customerID)
);
create table Flight(
flightID Int Auto_Increment,
departureCity varchar (50),
arrivalCity varchar (50),
departureTime time,
arrivalTime time,
airplaneid numeric (4),
primary key (flightID)
);

create table airplane(
airplaneID Int Auto_Increment,
maxCapacity numeric (3),
currentCapacity numeric (3),
primary key (airplaneID)
);
create table bookCheck(
BookedID Int,
CustomerID Int,
FlightID Int
);
Insert into Flight(flightID, departureCity, arrivalCity, departureTime, arrivalTime, airplaneid)
Values
(1, 'Atlanta', 'Los Angelos',11-30-00,15-30-00, 1),
(2, 'Atlanta', 'Los Angelos',11-30-00,15-30-00, 1),
(3, 'Atlanta', 'Los Angelos',11-30-00,15-30-00, 1),
(4, 'Atlanta', 'Los Angelos',11-30-00,15-30-00, 1),
(5, 'Atlanta', 'Los Angelos',11-30-00,15-30-00, 1),
(6, 'Atlanta', 'Los Angelos',11-30-00,15-30-00, 1),
(7, 'Atlanta', 'Los Angelos',11-30-00,15-30-00, 1),
(8, 'Atlanta', 'Los Angelos',11-30-00,15-30-00, 1),
(9, 'Atlanta', 'Los Angelos',11-30-00,15-30-00, 1),
(10, 'Atlanta', 'Los Angelos',11-30-00,15-30-00, 1),
(11, 'Atlanta', 'Los Angelos',11-30-00,15-30-00, 1),
(12, 'Atlanta', 'Los Angelos',11-30-00,15-30-00, 1),
(13, 'Atlanta', 'Los Angelos',11-30-00,15-30-00, 1),
(14, 'Atlanta', 'Los Angelos',11-30-00,15-30-00, 1),
(15, 'Atlanta', 'Los Angelos',11-30-00,15-30-00, 1),
(16, 'Atlanta', 'Los Angelos',11-30-00,15-30-00, 1),
(17, 'Atlanta', 'Los Angelos',11-30-00,15-30-00, 1),
(18, 'Atlanta', 'Los Angelos',11-30-00,15-30-00, 1),
(18, 'Atlanta', 'Los Angelos',11-30-00,15-30-00, 1),
(19, 'Atlanta', 'Los Angelos',11-30-00,15-30-00, 1);
