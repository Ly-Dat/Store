
-- Create new Persons table
CREATE TABLE Persons (
	P_Id int AUTO_INCREMENT primary key,
	LastName varchar(255), 
	FirstName varchar(255),
	Address varchar(255), 
	City varchar(255)
);


-- Insert data into Persons table
INSERT INTO Persons
VALUES (1,'Dennis','Stone','123 Beach','Bostob'), 
(2,'Trab','BCD','23 Nguyen Trai','TDM'),
(3,'Nguyen','ABC','12 Nguyen Thai Binh','HCM'), 
(4,'Miller','Josh','7373 Johnson','Westminster'),
(5,'Le','Hoang','21/4 Tran Hung Dao','HCM'), 
(6,'Ha','Tuyen','272 Nguyen Duc Thuan','TDM');
-- use comma (,) to separate VALUES for one INSERT INTO

-- able to use one by one with (;) after each statement
INSERT INTO Persons
VALUES (7,'Ha','Tuyen','272 Nguyen Duc Thuan','TDM');

INSERT INTO Persons
VALUES (8,'Jen','Worth','27282 Garden Grove','Stanton');


-- Create new table Orders
CREATE TABLE Orders (
	O_Id int NOT NULL,
    OrderNo int NOT NULL,
    P_Id int,
    Primary Key(O_Id),
    Foreign Key(P_Id) References Persons(P_Id)
);

-- Insert data into Orders table
INSERT INTO Orders
VALUES (1, 62722,3),
	(2, 53355,3),
    (3, 56656,2),
    (4, 42442,1);



