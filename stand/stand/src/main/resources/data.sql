
INSERT INTO Stand (standID, stand_Name,stand_Address, stand_Phone_Number, stand_Nif, stand_Email_Address) VALUES (1, 'L&M Stand', 'Rua das flores', '255090887', '123456712', 'lm@gmail.com');

INSERT INTO Client (clientID, client_Name, client_Address, client_Phone_Number, client_Nif, client_Email_Address, stand_standid) VALUES (1, 'António Rodrigues','Rua das pedras', '910223456', 123443567, 'antoniorodrigues@gmail.com', 1);
INSERT INTO Client (clientID, client_Name, client_Address, client_Phone_Number, client_Nif, client_Email_Address, stand_standid) VALUES (2, 'Maria Ribeiro','Rua das travessas', '910223445', 145778091, 'mariaribeiro@gmail.com', 1);
INSERT INTO Client (clientID, client_Name, client_Address, client_Phone_Number, client_Nif, client_Email_Address, stand_standid) VALUES (3, 'Joana Antunes','Rua do sol', '912908779', 123445678, 'joanaantunes@gmail.com', 1);
INSERT INTO Client (clientID, client_Name, client_Address, client_Phone_Number, client_Nif, client_Email_Address, stand_standid) VALUES (4, 'Rui Silva','Rua 25 de abril', '934990887', 889001829, 'ruisilva@gmail.com', 1);
INSERT INTO Client (clientID, client_Name, client_Address, client_Phone_Number, client_Nif, client_Email_Address, stand_standid) VALUES (5, 'Madalena Rocha','Rua das rosas', '919112345', 226778909, 'madalenarocha@gmail.com', 1);
INSERT INTO Client (clientID, client_Name, client_Address, client_Phone_Number, client_Nif, client_Email_Address, stand_standid) VALUES (6, 'Manuel Trigo','Rua do pastor', '920889749', 123332456, 'manueltrigo@gmail.com', 1);
INSERT INTO Client (clientID, client_Name, client_Address, client_Phone_Number, client_Nif, client_Email_Address, stand_standid) VALUES (7, 'Mariana Ferreira','Rua 21 de maio', '919112344', 123443556, 'marianaferreira@gmail.com', 1);
INSERT INTO Client (clientID, client_Name, client_Address, client_Phone_Number, client_Nif, client_Email_Address, stand_standid) VALUES (8, 'Pedro Rocha','Rua da Felicidade', '920889747', 123443679, 'pedrorocha@gmail.com', 1);
INSERT INTO Client (clientID, client_Name, client_Address, client_Phone_Number, client_Nif, client_Email_Address, stand_standid) VALUES (9, 'Francisco Costa','Rua do passo', '919112349', 226990889, 'franciscocosta@gmail.com', 1);
INSERT INTO Client (clientID, client_Name, client_Address, client_Phone_Number, client_Nif, client_Email_Address, stand_standid) VALUES (10, 'Raquel Cerqueira','Rua da Hora', '920889789', 123222343, 'raquelcerqueira@gmail.com', 1);
INSERT INTO Client (clientID, client_Name, client_Address, client_Phone_Number, client_Nif, client_Email_Address, stand_standid) VALUES (11, 'Cristina Matos','Rua do roubado', '917492345', 226112332, 'cristinamatos@gmail.com', 1);
INSERT INTO Client (clientID, client_Name, client_Address, client_Phone_Number, client_Nif, client_Email_Address, stand_standid) VALUES (12, 'Rafael Nunes','Rua do cerco', '921119749', 123999090, 'rafaelnunes@gmail.com', 1);
INSERT INTO Client (clientID, client_Name, client_Address, client_Phone_Number, client_Nif, client_Email_Address, stand_standid) VALUES (13, 'Marco Silva','Rua das peso da régua', '919122245', 226112332, 'marcosilva@gmail.com', 1);
INSERT INTO Client (clientID, client_Name, client_Address, client_Phone_Number, client_Nif, client_Email_Address, stand_standid) VALUES (14, 'Paulo Gomes','Rua da cordoaria', '920888749', 123999000, 'paulogomes@gmail.com', 1);
INSERT INTO Client (clientID, client_Name, client_Address, client_Phone_Number, client_Nif, client_Email_Address, stand_standid) VALUES (15, 'Margarida Jesus','Rua dos aliados', '919993345', 226111234, 'margaridajesus@gmail.com', 1);
INSERT INTO Client (clientID, client_Name, client_Address, client_Phone_Number, client_Nif, client_Email_Address, stand_standid) VALUES (16, 'Ana Silva','Rua da maia', '919112245', 226998778, 'anasilva@gmail.com', 1);




INSERT INTO Brand (brandID, brand_Name) VALUES (1, 'Toyota');
INSERT INTO Brand (brandID, brand_Name) VALUES (2, 'BMW');
INSERT INTO Brand (brandID, brand_Name) VALUES (3, 'Ferrari');
INSERT INTO Brand (brandID, brand_Name) VALUES (4, 'Porsche');
INSERT INTO Brand (brandID, brand_Name) VALUES (5, 'Honda');
INSERT INTO Brand (brandID, brand_Name) VALUES (6, 'Audi');
INSERT INTO Brand (brandID, brand_Name) VALUES (7, 'Mercedes');

INSERT INTO Model (modelID, model_Name,brand_Name_brandID) VALUES (1, 'Serie 1',1);
INSERT INTO Model (modelID, model_Name,brand_Name_brandID) VALUES (2, 'Serie 2',2);
INSERT INTO Model (modelID, model_Name,brand_Name_brandID) VALUES (3, 'Serie 3',3);
INSERT INTO Model (modelID, model_Name,brand_Name_brandID) VALUES (4, 'X1',4);
INSERT INTO Model (modelID, model_Name,brand_Name_brandID) VALUES (5, 'X2',5);
INSERT INTO Model (modelID, model_Name,brand_Name_brandID) VALUES (6, 'X3',6);
INSERT INTO Model (modelID, model_Name,brand_Name_brandID) VALUES (7, 'X4',7);

INSERT INTO Vehicle (vehicleID, vehicle_Name, vehicle_License_Plate, vehicle_Number_Seats, vehicle_Number_Doors, vehicle_Traction, vehicle_Fuel, vehicle_Color, vehicle_Type, vehicle_Status, client_clientid, model_modelid) VALUES (1, 'Toyota Avensis', 'AA-01-AA', 5, 4, 1, 1, 'Preto', 0, 3, 1, 1);
INSERT INTO Vehicle (vehicleID, vehicle_Name, vehicle_License_Plate, vehicle_Number_Seats, vehicle_Number_Doors, vehicle_Traction, vehicle_Fuel, vehicle_Color, vehicle_Type, vehicle_Status, client_clientid, model_modelid) VALUES (2, 'BMW X1', 'BB-01-BB', 5, 4, 2, 0, 'Branco', 1, 0, 2, 4);
INSERT INTO Vehicle (vehicleID, vehicle_Name, vehicle_License_Plate, vehicle_Number_Seats, vehicle_Number_Doors, vehicle_Traction, vehicle_Fuel, vehicle_Color, vehicle_Type, vehicle_Status, client_clientid, model_modelid) VALUES (3, 'Ferrari Portofino', 'AB-01-AB', 2, 2, 3, 0, 'Vermelho', 4, 1, 3, 2);
INSERT INTO Vehicle (vehicleID, vehicle_Name, vehicle_License_Plate, vehicle_Number_Seats, vehicle_Number_Doors, vehicle_Traction, vehicle_Fuel, vehicle_Color, vehicle_Type, vehicle_Status, client_clientid, model_modelid) VALUES (4, 'Porsche Panamera', 'AA-10-AA', 4, 4, 3, 3, 'Cinzento', 0, 2, 4, 4);
INSERT INTO Vehicle (vehicleID, vehicle_Name, vehicle_License_Plate, vehicle_Number_Seats, vehicle_Number_Doors, vehicle_Traction, vehicle_Fuel, vehicle_Color, vehicle_Type, vehicle_Status, client_clientid, model_modelid) VALUES (5, 'Ferrari Roma', 'AA-71-AA', 2, 2, 3, 0, 'Vermelho', 3, 5, 5, 3);
INSERT INTO Vehicle (vehicleID, vehicle_Name, vehicle_License_Plate, vehicle_Number_Seats, vehicle_Number_Doors, vehicle_Traction, vehicle_Fuel, vehicle_Color, vehicle_Type, vehicle_Status, client_clientid, model_modelid) VALUES (6, 'Toyota Yaris', 'AA-21-AA', 5, 4, 2, 3, 'Azul', 2, 4, 6, 2);
INSERT INTO Vehicle (vehicleID, vehicle_Name, vehicle_License_Plate, vehicle_Number_Seats, vehicle_Number_Doors, vehicle_Traction, vehicle_Fuel, vehicle_Color, vehicle_Type, vehicle_Status, client_clientid, model_modelid) VALUES (7, 'Toyota Yaris', 'BB-20-BB', 5, 4, 2, 3, 'Azul', 2, 6, 1, 2);
INSERT INTO Vehicle (vehicleID, vehicle_Name, vehicle_License_Plate, vehicle_Number_Seats, vehicle_Number_Doors, vehicle_Traction, vehicle_Fuel, vehicle_Color, vehicle_Type, vehicle_Status, client_clientid, model_modelid) VALUES (8, 'Toyota Prius', 'AB-22-CC', 5, 4, 2, 3, 'Preto', 2, 7, 6, 2);
INSERT INTO Vehicle (vehicleID, vehicle_Name, vehicle_License_Plate, vehicle_Number_Seats, vehicle_Number_Doors, vehicle_Traction, vehicle_Fuel, vehicle_Color, vehicle_Type, vehicle_Status, client_clientid, model_modelid) VALUES (9, 'Honda Civic', 'BC-28-BC', 5, 4, 2, 0, 'Azul', 0, 1, 1, 2);
INSERT INTO Vehicle (vehicleID, vehicle_Name, vehicle_License_Plate, vehicle_Number_Seats, vehicle_Number_Doors, vehicle_Traction, vehicle_Fuel, vehicle_Color, vehicle_Type, vehicle_Status, client_clientid, model_modelid) VALUES (10, 'Honda Odyssey', 'AD-20-AD', 8, 4, 2, 0, 'Cinzento', 5, 2, 7, 2);
INSERT INTO Vehicle (vehicleID, vehicle_Name, vehicle_License_Plate, vehicle_Number_Seats, vehicle_Number_Doors, vehicle_Traction, vehicle_Fuel, vehicle_Color, vehicle_Type, vehicle_Status, client_clientid, model_modelid) VALUES (11, 'BMW X4', 'BB-10-BB', 5, 4, 2, 3, 'Branco', 1, 0, 8, 7);
INSERT INTO Vehicle (vehicleID, vehicle_Name, vehicle_License_Plate, vehicle_Number_Seats, vehicle_Number_Doors, vehicle_Traction, vehicle_Fuel, vehicle_Color, vehicle_Type, vehicle_Status, client_clientid, model_modelid) VALUES (12, 'Mercedes-Benz', 'AA-15-AA', 5, 4, 2, 3, 'Vermelho', 0, 3, 9, 2);
INSERT INTO Vehicle (vehicleID, vehicle_Name, vehicle_License_Plate, vehicle_Number_Seats, vehicle_Number_Doors, vehicle_Traction, vehicle_Fuel, vehicle_Color, vehicle_Type, vehicle_Status, client_clientid, model_modelid) VALUES (13, 'Audi', 'BD-22-BD', 5, 4, 2, 3, 'Amarelo', 0, 4, 10, 2);
INSERT INTO Vehicle (vehicleID, vehicle_Name, vehicle_License_Plate, vehicle_Number_Seats, vehicle_Number_Doors, vehicle_Traction, vehicle_Fuel, vehicle_Color, vehicle_Type, vehicle_Status, client_clientid, model_modelid) VALUES (14, 'Ferrari', 'AA-18-DD', 2, 2, 3, 0, 'Preto', 4, 5, 11, 2);
INSERT INTO Vehicle (vehicleID, vehicle_Name, vehicle_License_Plate, vehicle_Number_Seats, vehicle_Number_Doors, vehicle_Traction, vehicle_Fuel, vehicle_Color, vehicle_Type, vehicle_Status, client_clientid, model_modelid) VALUES (15, 'BMW X2', 'BB-23-CC', 5, 4, 2, 3, 'Branco', 0, 6, 12, 5);
INSERT INTO Vehicle (vehicleID, vehicle_Name, vehicle_License_Plate, vehicle_Number_Seats, vehicle_Number_Doors, vehicle_Traction, vehicle_Fuel, vehicle_Color, vehicle_Type, vehicle_Status, client_clientid, model_modelid) VALUES (16, 'Mercedes', 'AA-29-AD', 5, 4, 2, 3, 'Verde', 0, 7, 13, 2);
INSERT INTO Vehicle (vehicleID, vehicle_Name, vehicle_License_Plate, vehicle_Number_Seats, vehicle_Number_Doors, vehicle_Traction, vehicle_Fuel, vehicle_Color, vehicle_Type, vehicle_Status, client_clientid, model_modelid) VALUES (17, 'Toyota', 'BB-11-BC', 5, 4, 1, 1, 'Azul', 0, 1, 14, 2);
INSERT INTO Vehicle (vehicleID, vehicle_Name, vehicle_License_Plate, vehicle_Number_Seats, vehicle_Number_Doors, vehicle_Traction, vehicle_Fuel, vehicle_Color, vehicle_Type, vehicle_Status, client_clientid, model_modelid) VALUES (18, 'Porche turbo', 'DD-02-AA', 4, 4, 3, 3, 'Preto', 0, 2, 15, 2);
INSERT INTO Vehicle (vehicleID, vehicle_Name, vehicle_License_Plate, vehicle_Number_Seats, vehicle_Number_Doors, vehicle_Traction, vehicle_Fuel, vehicle_Color, vehicle_Type, vehicle_Status, client_clientid, model_modelid) VALUES (19, 'BMW X3', 'BD-05-BB', 5, 4, 2, 3, 'Azul', 1, 0, 16, 6);
INSERT INTO Vehicle (vehicleID, vehicle_Name, vehicle_License_Plate, vehicle_Number_Seats, vehicle_Number_Doors, vehicle_Traction, vehicle_Fuel, vehicle_Color, vehicle_Type, vehicle_Status, client_clientid, model_modelid) VALUES (20, 'BMW Serie 1', 'AC-24-AA', 5, 4, 2, 0, 'Branco', 1, 3, 16, 1);
INSERT INTO Vehicle (vehicleID, vehicle_Name, vehicle_License_Plate, vehicle_Number_Seats, vehicle_Number_Doors, vehicle_Traction, vehicle_Fuel, vehicle_Color, vehicle_Type, vehicle_Status, client_clientid, model_modelid) VALUES (21, 'Toyota Yaris', 'BB-17-BB', 5, 4, 2, 3, 'Amarelo', 0, 4, 16, 2);






