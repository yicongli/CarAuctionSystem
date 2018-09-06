CREATE SCHEMA APP;

DROP TABLE APP.buyer;
DROP TABLE APP.seller;
DROP TABLE APP.car;
DROP TABLE APP.buyer_car;

CREATE TABLE APP.buyer(
   id			INT,
   username 	VARCHAR(50),
   password		VARCHAR(50),
   firstname	VARCHAR(50),
   lastname		VARCHAR(50),
   phoneno		VARCHAR(15),
   PRIMARY KEY (id)
);

INSERT INTO APP.buyer
VALUES (1, 'buyer1', '1234', 'John', 'Wick', '0412345678');
INSERT INTO APP.buyer
VALUES (2, 'buyer2', '1234', 'Vito', 'Corleone', '0412345679');

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
   id			INT,
   sellerID		INT,
   regno	 	VARCHAR(50),
   make			VARCHAR(50),
   model		VARCHAR(50),
   year 		INT,
   price		FLOAT,
   salesdate	DATE,
   currentbid	FLOAT,
   PRIMARY KEY (id),
   FOREIGN KEY (sellerID) REFERENCES APP.seller (id)
);

INSERT INTO APP.car (id, sellerID, regno, make, model, year, price, salesdate)
VALUES (1, 1, 'REG123', 'Toyota', 'Yaris', 2017, 9000, '06-09-18');

INSERT INTO APP.car (id, sellerID, regno, make, model, year, price, salesdate)
VALUES (2, 1, 'REG123', 'Mercedes', 'C-Class', 2014, 12000, '06-09-18');

CREATE TABLE APP.buyer_car(
	buyerID		INT,
	carID		INT,
	FOREIGN KEY (buyerID) REFERENCES APP.buyer (id),
	FOREIGN KEY (carID) REFERENCES APP.car (id)
);