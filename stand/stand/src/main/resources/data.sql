
INSERT INTO Stand (standID, stand_Name,stand_Address, stand_Phone_Number, stand_Nif, stand_Email_Address) VALUES (1, 'L&M Stand', 'Rua das flores', '255090887', '123456712', 'lm@gmail.com');

INSERT INTO Client (clientID, client_Name, client_Address, client_Phone_Number, client_Nif, client_Email_Address, stand_standid) VALUES (1, 'António Rodrigues','Rua das pedras', '910223456', 123443567, 'antoniorodrigues@gmail.com', 1);
INSERT INTO Client (clientID, client_Name, client_Address, client_Phone_Number, client_Nif, client_Email_Address, stand_standid) VALUES (2, 'Maria Ribeiro','Rua das travessas', '910223445', 145778091, 'mariaribeiro@gmail.com', 1);
INSERT INTO Client (clientID, client_Name, client_Address, client_Phone_Number, client_Nif, client_Email_Address, stand_standid) VALUES (3, 'Joana Antunes','Rua do sol', '912908779', 123445678, 'joanaantunes@gmail.com', 1);
INSERT INTO Client (clientID, client_Name, client_Address, client_Phone_Number, client_Nif, client_Email_Address, stand_standid) VALUES (4, 'Rui Silva','Rua 25 de abril', '934990887', 889001829, 'ruisilva@gmail.com', 1);
INSERT INTO Client (clientID, client_Name, client_Address, client_Phone_Number, client_Nif, client_Email_Address, stand_standid) VALUES (5, 'Madalena Rocha','Rua das rosas', '919112345', 226778909, 'madalenarocha@gmail.com', 1);
INSERT INTO Client (clientID, client_Name, client_Address, client_Phone_Number, client_Nif, client_Email_Address, stand_standid) VALUES (6, 'Manuel Trigo','Rua do pastor', '920889749', 123332456, 'manueltrigo@gmail.com', 1);


INSERT INTO Brand (brandID, brand_Name) VALUES (1, 'Toyota');
INSERT INTO Brand (brandID, brand_Name) VALUES (2, 'BMW');
INSERT INTO Brand (brandID, brand_Name) VALUES (3, 'Ferrari');
INSERT INTO Brand (brandID, brand_Name) VALUES (4, 'Porsche');

INSERT INTO Model (modelID, model_Name,brand_Name_brandID) VALUES (1, 'bbcfe',1);
INSERT INTO Model (modelID, model_Name,brand_Name_brandID) VALUES (2, 'vrrbte',2);
INSERT INTO Model (modelID, model_Name,brand_Name_brandID) VALUES (3, 'bgtre',3);
INSERT INTO Model (modelID, model_Name,brand_Name_brandID) VALUES (4, 'bcwwwe',4);

INSERT INTO Vehicle (vehicleID, vehicle_Name, vehicle_License_Plate, vehicle_Number_Seats, vehicle_Number_Doors, vehicle_Traction, vehicle_Fuel, vehicle_Color, vehicle_Type, vehicle_Status, client_clientid, model_modelid) VALUES (1, 'Toyota Avensis', 'AA-01-AA', 4, 4, 2, 1, 'Preto', 0, 3, 1, 1);
INSERT INTO Vehicle (vehicleID, vehicle_Name, vehicle_License_Plate, vehicle_Number_Seats, vehicle_Number_Doors, vehicle_Traction, vehicle_Fuel, vehicle_Color, vehicle_Type, vehicle_Status, client_clientid, model_modelid) VALUES (2, 'BMW X1', 'BB-01-BB', 4, 5, 2, 0, 'Branco', 1, 0, 2, 3);
INSERT INTO Vehicle (vehicleID, vehicle_Name, vehicle_License_Plate, vehicle_Number_Seats, vehicle_Number_Doors, vehicle_Traction, vehicle_Fuel, vehicle_Color, vehicle_Type, vehicle_Status, client_clientid, model_modelid) VALUES (3, 'Ferrari Portofino', 'AB-01-AB', 4, 2, 3, 0, 'Vermelho', 4, 1, 3, 2);
INSERT INTO Vehicle (vehicleID, vehicle_Name, vehicle_License_Plate, vehicle_Number_Seats, vehicle_Number_Doors, vehicle_Traction, vehicle_Fuel, vehicle_Color, vehicle_Type, vehicle_Status, client_clientid, model_modelid) VALUES (4, 'Porsche Panamera', 'AA-10-AA', 4, 4, 3, 3, 'Cinzento', 0, 2, 4, 4);
INSERT INTO Vehicle (vehicleID, vehicle_Name, vehicle_License_Plate, vehicle_Number_Seats, vehicle_Number_Doors, vehicle_Traction, vehicle_Fuel, vehicle_Color, vehicle_Type, vehicle_Status, client_clientid, model_modelid) VALUES (5, 'Ferrari Roma', 'AA-71-AA', 2, 2, 3, 0, 'Vermelho', 4, 5, 5, 3);
INSERT INTO Vehicle (vehicleID, vehicle_Name, vehicle_License_Plate, vehicle_Number_Seats, vehicle_Number_Doors, vehicle_Traction, vehicle_Fuel, vehicle_Color, vehicle_Type, vehicle_Status, client_clientid, model_modelid) VALUES (6, 'Toyota Yaris', 'AA-22-AA', 5, 4, 2, 3, 'Azul', 2, 4, 6, 2);






