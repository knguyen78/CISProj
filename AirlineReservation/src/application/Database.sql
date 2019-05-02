create table registration(
customerID INT Auto_Increment Not Null,
firstname varchar(50) Not Null,
lastname varchar(50) Not Null,
address varchar(50) Not Null,
zip numeric(5) Not Null,
state varchar(2) Not Null,
username varchar(30) Not Null,
pword varchar(30) Not Null,
email varchar(30) Not Null,
SSN numeric (9) Not Null,
securityQuestion varchar(100) Not Null,
securityAnswer varchar(100) Not Null,
isAdmin boolean Not Null,
primary key (customerID)
);
create table Flight(
flightID Int Auto_Increment,
departureCity varchar (50) Not Null,
arrivalCity varchar (50) Not Null,
departureTime time Not Null,
arrivalTime time Not Null,
airplaneid numeric (4) Not Null,
primary key (flightID)
);

create table airplane(
airplaneID Int Auto_Increment Not Null,
maxCapacity numeric (3) Not Null,
currentCapacity numeric (3) Not Null,
primary key (airplaneID)
);
create table bookCheck(
BookedID Int Not Null,
CustomerID Int Not Null,
FlightID Int Not Null
);


Insert into Flight(departureCity, arrivalCity, departureTime, arrivalTime, airplaneid)
Values
('Atlanta', 'Los Angelos','11:30:00','15:00:00', 1),
('New York', 'London','11:30:00','15:30:00', 1),
('London', 'Atlanta','11:30:00','15:30:00', 1),
('Boston', 'San Fransisco','11:30:00','15:30:00', 1),
('Denver', 'Seattle','11:30:00','15:30:00', 1),
('Paris', 'London','11:30:00','15:30:00', 1),
('Seattle', 'Boston','11:30:00','15:30:00', 1),
('San Fransisco', 'Los Angelos','11:30:00','15:30:00', 1),
('Atlanta', 'Los Angelos','11:30:00','15:30:00', 1),
('Atlanta', 'Los Angelos','11:30:00','15:30:00', 1),
('Atlanta', 'Los Angelos','11:30:00','15:30:00', 1),
('Atlanta', 'Los Angelos','11:30:00','15:30:00', 1),
('Atlanta', 'Los Angelos','11:30:00','15:30:00', 1),
('Atlanta', 'Los Angelos','11:30:00','15:30:00', 1),
('Atlanta', 'Los Angelos','11:30:00','15:30:00', 1),
('Atlanta', 'Los Angelos','11:30:00','15:30:00', 1),
('Atlanta', 'Los Angelos','11:30:00','15:30:00', 1),
('Atlanta', 'Los Angelos','11:30:00','15:30:00', 1),
('Atlanta', 'Los Angelos','11:30:00','15:30:00', 1),
('Atlanta', 'Los Angelos','11:30:00','15:30:00', 1);

Insert into registration(firstname, lastname, address, zip, state, username, pword, 
email, SSN, securityQuestion, securityAnswer, isAdmin)
Values
('Charles', 'Money', '141 Piedmont AV', '30080','GA','cmoney',
'password','cmoney3@student.gsu.edu',111111111,'What is the Answer', '42',true),

('Nolan', 'Bullard', '141 Piedmont AV', '30080','GA','nbullard',
'password','nolanbullard@gmail.com',222222222,'What is the Answer', '42',true),

('Kat', 'Nguyen', '141 Piedmont AV', '30080','GA','knguyen',
'password','kathy0nguyen@gmail.com',333333333,'What is the Answer', '42',true);



Select * 
From Flight;
