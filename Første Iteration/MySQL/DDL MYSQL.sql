use nmr;

CREATE TABLE Zipcode (
zipCode				VARCHAR(45) 	NOT NULL 	PRIMARY KEY,
City				VARCHAR(45)		NOT NULL,
Country				VARCHAR(45)		NOT NULL
);

CREATE TABLE Customer (
id					INT				NOT NULL	PRIMARY KEY		AUTO_INCREMENT,
firstName			VARCHAR(45) 	NOT NULL,
lastName			VARCHAR(45) 	NOT NULL,
phoneNumber			VARCHAR(8) 		NOT NULL	UNIQUE,
email				VARCHAR(100)	NOT NULL	UNIQUE,
address				VARCHAR(100) 	NOT NULL,
driverLicenceNumber	VARCHAR(45)		NOT NULL 	UNIQUE,
zipCode				VARCHAR(45),
FOREIGN KEY (zipCode) REFERENCES Zipcode(zipCode)
);

CREATE TABLE Motorhome (
id					INT				NOT NULL	PRIMARY KEY		AUTO_INCREMENT,
brand				VARCHAR(45) 	NOT NULL,
model				VARCHAR(45) 	NOT NULL,
odometer			INT				NOT NULL,
vehicleSize			VARCHAR(45)		NOT NULL,
vehicleType			VARCHAR(45)		NOT NULL,
pricePerDay			INT				NOT NULL,
serviceNote			VARCHAR(250)
);

CREATE TABLE Employee (
id					INT 			NOT NULL 	PRIMARY KEY 	AUTO_INCREMENT,
firstName			VARCHAR(45) 	NOT NULL,
lastName			VARCHAR(45) 	NOT NULL,
phoneNumber			VARCHAR(8) 		NOT NULL	UNIQUE,
email				VARCHAR(100)	NOT NULL	UNIQUE,
address				VARCHAR(100) 	NOT NULL,
title				VARCHAR(45)		NOT NULL,
zipCode				VARCHAR(45),
FOREIGN KEY (zipCode) REFERENCES Zipcode(zipCode)
);

CREATE TABLE Contract (
id					INT				NOT NULL	PRIMARY KEY		AUTO_INCREMENT,
rentalStartDate		DATETIME		DEFAULT NULL,
rentalEndDate		DATETIME		DEFAULT NULL,
pickUpPoint			VARCHAR(100),
dropOffPoint		VARCHAR(100),
customerId			INT,
motorhomeId			INT,
employeeId			INT,
bikeRack			INT 			DEFAULT 0,
bedLinen			INT 			DEFAULT 0,
childSeat			INT 			DEFAULT 0,
picnicTable			INT 			DEFAULT 0,
chairs				INT 			DEFAULT 0,
grill 				INT 			DEFAULT 0,
lantern 			INT 			DEFAULT 0,
firstAidKit 		INT			 	DEFAULT 0,
toiletPaper 		INT 			DEFAULT 0,
active 				tinyint(1) 		default 1,
FOREIGN KEY (customerId) REFERENCES Customer(id),
FOREIGN KEY	(motorhomeId) REFERENCES Motorhome(id),
FOREIGN KEY (employeeId) REFERENCES Employee(id)
);



