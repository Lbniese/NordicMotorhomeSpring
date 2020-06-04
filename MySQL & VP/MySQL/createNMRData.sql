DELETE FROM Contract;
ALTER TABLE Contract AUTO_INCREMENT = 1;

DELETE FROM Motorhome;
ALTER TABLE Motorhome AUTO_INCREMENT = 1;


DELETE FROM Employee;
ALTER TABLE Employee AUTO_INCREMENT = 1;

DELETE FROM Customer;
ALTER TABLE Customer AUTO_INCREMENT = 1;


INSERT INTO Customer (firstName, lastName, phoneNumber, email, address, driverLicenceNumber, zipCode)
VALUES
('Peter', 'Melander', '61750924', 'melander2910@hotmail.com', 'Hans Knudsens Plads 3101', '64758492', '2100'),
('Mikkel', 'Karlsson', '21432465', 'mikkelkarlsson@gmail.com', 'Aborrevænget 13', '75840043', '4760');

INSERT INTO Employee (firstName, lastName, phoneNumber, email, address, title, zipCode)
VALUES
('Jakob', 'Lorenzen', '61852726', 'osaki@lupra.org', 'Strandgade 18', 'Accountant', '2000'),
('Emilie', 'Geldorf', '22970005', 'Emiliegeldorf@gmail.com', 'Drejøgade 26b, 4., 403', 'Sales Assistant', '2100');

INSERT INTO Motorhome (brand, model, odometer, vehicleSize, vehicleType, pricePerDay, serviceNote)
VALUES
('Carthago', 'Compactline 144 LE', '200', 'Large', 'Class B Motorhome', '800', '');

INSERT INTO Contract (rentalStartDate, rentalEndDate, pickUpPoint, dropOffPoint, customerId, motorhomeId, employeeId, bikeRack, bedLinen, childSeat, picnicTable, chairs, grill, lantern, firstAidKit, toiletPaper, active, kmDriven, fuelCharge)
VALUES
('2020-12-12 13:00:00', '2020-12-25 21:00:00', 'NMR - Headquarters', 'NMR - Headquarters', '1', '1', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0');


