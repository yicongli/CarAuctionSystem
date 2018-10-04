DROP TABLE APP.buyer;
DROP TABLE APP.seller;
DROP TABLE APP.car;
DROP TABLE APP.buyer_car;

CREATE TABLE APP.buyer(
   id			INT GENERATED ALWAYS AS IDENTITY,
   username 	VARCHAR(50),
   password		VARCHAR(50),
   firstname	VARCHAR(50),
   lastname		VARCHAR(50),
   phoneno		VARCHAR(15),
   PRIMARY KEY (id)
);

INSERT INTO APP.buyer (username, password, firstname, lastname, phoneno)
VALUES ('buyer1', '1234', 'John', 'Wick', '0412345678');
INSERT INTO APP.buyer (username, password, firstname, lastname, phoneno)
VALUES ('buyer2', '1234', 'Vito', 'Corleone', '0412345679');

CREATE TABLE APP.seller(
   id			INT,
   username 	VARCHAR(50),
   password		VARCHAR(50),
   address		VARCHAR(100),
   PRIMARY KEY (id)
);

INSERT INTO APP.seller
VALUES (1, 'Seller', '1234', 'Parkville Victoria 3010');

CREATE TABLE APP.car(
   id			INT GENERATED ALWAYS AS IDENTITY,
   sellerID		INT,
   regno	 	VARCHAR(50),
   make			VARCHAR(50),
   model		VARCHAR(50),
   variant		VARCHAR(50),
   buildyear	INT,
   price		FLOAT,
   salesdate	BIGINT,
   currentbid	FLOAT,
   PRIMARY KEY (id),
   FOREIGN KEY (sellerID) REFERENCES APP.seller (id)
);

INSERT INTO APP.car (sellerID, regno, make, model, variant, buildyear, price, salesdate)
VALUES (1, 'REG111', 'Toyota', 'Yaris', 'Variant 87', 2017, 9000, '2018-09-06 12:00:00');

INSERT INTO APP.car (sellerID, regno, make, model, variant, buildyear, price, salesdate)
VALUES (1, 'REG222', 'Mercedes', 'C-Class', 'Variant 5', 2014, 12000, '2018-09-07 12:00:00');

CREATE TABLE APP.buyer_car(
	buyerID			INT,
	carID			INT,
	pickuplocation 	VARCHAR(100),
	PRIMARY KEY (buyerID, carID),
	FOREIGN KEY (buyerID) REFERENCES APP.buyer (id),
	FOREIGN KEY (carID) REFERENCES APP.car (id)
);