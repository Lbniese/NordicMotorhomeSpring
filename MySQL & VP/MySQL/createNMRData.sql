use nmr;

DELETE FROM Contract where id > 0;
ALTER TABLE Contract AUTO_INCREMENT = 1;

DELETE FROM Motorhome where id > 0;
ALTER TABLE Motorhome AUTO_INCREMENT = 1;

DELETE FROM Employee where id > 0;
ALTER TABLE Employee AUTO_INCREMENT = 1;

DELETE FROM Customer where id > 0;
ALTER TABLE Customer AUTO_INCREMENT = 1;


INSERT INTO Customer (firstName, lastName, phoneNumber, email, address, driverLicenceNumber, zipCode)
VALUES
('Peter', 'Melander', '61750924', 'melander2910@hotmail.com', 'Hans Knudsens Plads 3101', '64758492', '2100'),
('Mikkel', 'Karlsson', '21432465', 'mikkelkarlsson@gmail.com', 'Aborrevænget 13', '75840043', '4760'),
('Hanne', 'Knudsen', '76009283', 'Hanneknudsen@gmail.com', 'Havrevænget 21', '87543564', '2400'),
('Karsten', 'Lund', '44224112', 'lund@outlook.dk', 'Vallenhøjen 1A', '01958485', '8000'),
('Louise', 'Kristensen', '21226765', 'lkristensen@hotmail.com', 'Kristinelunden 65', '77009089', '4720'),
('Berta', 'Minosque', '55990021', 'monisque@hotmail.com', 'Langgade 21B 2.tv', '09849581', '2500'),
('Markus', 'Strange', '43950945', 'strange@outlook.com', 'Skovvej 22', '14268879', '4760'),
('Rasmus', 'Graff', '45778104', 'rasmus.graff@gmail.com', 'Hjørnehusvej 12', '99994123', '4720'),
('Caroline', 'Geldorf', '45829502', 'geldorfcaro@dbmail.com', 'Krajevig Alle 31A', '87114321', '4000'),
('Pilou', 'Asbæk', '61795085', 'pilouasbæk@contact.com', 'Vognmandsmarken 61B 2.tv', '14252699', '2100'),
('Mick', 'Øgendahl', '25281842', 'mickkomik@gmail.com', 'Svanemøllevej 84', '09418743', '2100'),
('Branco', 'Gilli', '74205439', 'universal@gmail.com', 'Aborrevænget 13', '61229004', '4760');

INSERT INTO Employee (firstName, lastName, phoneNumber, email, address, title, zipCode)
VALUES
('Jakob', 'Lorenzen', '61852726', 'osaki@lupra.org', 'Strandgade 18', 'Accountant', '2000'),
('Emilie', 'Geldorf', '22970005', 'Emiliegeldorf@gmail.com', 'Drejøgade 26b, 4., 403', 'Sales Assistant', '2100'),
('Kristian', 'Olivier', '27312364', 'olivier@live.dk', 'Frederiksborgvej 44 4.th', 'Auto mechanic', '2200'),
('Martin', 'Karlsen', '41420636', 'mkarls@hotmail.com', 'Valby Hovedgade 17 1.tv', 'Cleaning staff', '2500'),
('Filipa', 'Piraq', '97320043', 'piraq@gmail.com', 'Vigerslev 31 4.tv', 'Cleaning staff', '2500'),
('Dennis', 'Laursen', '22140942', 'dlaurs@gmail.com', 'Østerbrogade 64 2.tv', 'Sales Assistant', '2100'),
('Marianne', 'Biefelin', '87647281', 'biefelin-m@hotmail.com', 'Masnedøvej 21 3.th', 'Sales Assistant', '2100'),
('Marius', 'Valentin', '21724104', 'marius.valentin@outlook.dk', 'Valby langgade 28', 'Sales Assistant', '2500'),
('Emilie', 'Geldorf', '22970005', 'emiliegeldorf@gmail.com', 'Drejøgade 26b 403', 'Sales Assistant', '2100');

INSERT INTO Motorhome (brand, model, odometer, vehicleSize, vehicleType, pricePerDay, serviceNote)
VALUES
('Carthago', 'Compactline 144 LE', '200', 'Large', 'Class B Motorhome', '800', ''),
('Newmar', 'Dutch Star', '2200', 'Large', 'Class A Motorhome', '1500', ''),
('Newmar', 'Ventana', '12000', 'Large', 'Class A Motorhome', '1450', ''),
('Entegra', 'Aspire', '4100', 'Large', 'Class A Motorhome', '1000', ''),
('Entegra', 'Anthem', '6500', 'Large', 'Class A Motorhome', '950', ''),
('Airstream', 'Interstate 19', '7500', 'Small', 'Class B Motorhome', '500', ''),
('Hymer', 'Aktiv S', '14500', 'Small', 'Class B Motorhome', '550', ''),
('Carthago', 'Compactline 124 LE', '26500', 'Large', 'Class B Motorhome', '750', ''),
('Carthago', 'Compactline 144 LE', '4200', 'Large', 'Class B Motorhome', '850', ''),

('Winnebago', 'Aspect', '3500', 'Large', 'Class C Motorhome', '850', ''),
('Dynamax ', 'Isata 3', '5500', 'Large', 'Class C Motorhome', '800', ''),
('Jayco', 'Redhawk', '4000', 'Large', 'Class C Motorhome', '900', ''),
('Winnebago', 'Fuse', '17200', 'Large', 'Class C Motorhome', '750', ''),

('Flagstaff', 'Classic', '12000', 'Large', 'Travel trailer', '950', ''),
('Flagstaff', 'Shamrock', '21000', 'Large', 'Travel trailer', '950', ''),
('Cherokee', 'Grey Wolf', '4000', 'Large', 'Travel trailer', '1000', ''),
('Cherokee', 'Wolf Pup', '4000', 'Large', 'Travel trailer', '900', ''),

('Cherokee', 'Arctic Wolf', '2000', 'Large', 'Travel trailer', '1500', ''),
('Rockwood', 'Sabre', '16000', 'Large', 'Fifth Wheel trailer', '1600', ''),
('Rockwood', 'Classic', '24000', 'Large', 'Fifth Wheel trailer', '1600', ''),
('XLR', 'Boost', '4000', 'Large', 'Fifth Wheel trailer', '1700', ''),

('Forest River', 'R-Pod', '6000', 'Small', 'Hybrid Travel trailer', '450', ''),
('Airstream', 'Sport', '2000', 'Small', 'Hybrid Travel trailer', '500', ''),
('Jayco', 'Hummingbird', '2100', 'Small', 'Hybrid Travel trailer', '480', ''),
('Dutchmen', 'Coleman Lantern LT', '1000', 'Small', 'Hybrid Travel trailer', '425', ''),

('Coachmen', 'Clipper Pop-up', '1200', 'Small', 'Pop-up trailer', '250', ''),
('Sylvansport', 'Go Pop-up', '5600', 'Small', 'Pop-up trailer', '275', ''),
('Jayco', 'Jay Series Sport Pop-up', '450', 'Small', 'Pop-up trailer', '300', ''),
('Forest', 'River Rockwood Premier Pop-up', '1200', 'Small', 'Pop-up trailer', '275', ''),

('Cirrus', '920', '22500', 'Small', 'Truck Camper', '325', ''),
('Lance', '650', '11200', 'Small', 'Truck Camper', '350', ''),
('Northern', 'Lite 8-11 EX', '9000', 'Small', 'Truck Camper', '300', ''),
('Arctic Fox', '865', '12500', 'Small', 'Truck Camper', '350', ''),

('Montana', 'High Country 381TH', '12500', 'Large', 'Toy Hauler', '1325', ''),
('Heartland', 'Fuel 352', '12500', 'Large', 'Toy Hauler', '1225', ''),
('Jayco', 'Talon 413T', '12500', 'Large', 'Toy Hauler', '1300', ''),
('Raptor', '425TS', '12500', 'Small', 'Toy Hauler', '650', '');


INSERT INTO Contract (rentalStartDate, rentalEndDate, pickUpPoint, dropOffPoint, customerId, motorhomeId, employeeId, bikeRack, bedLinen, childSeat, picnicTable, chairs, grill, lantern, firstAidKit, toiletPaper, active, kmDriven, fuelCharge)
VALUES
('2020-12-12 13:00:00', '2020-12-25 21:00:00', 'NMR - Headquarters', 'NMR - Headquarters', '1', '1', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0');
