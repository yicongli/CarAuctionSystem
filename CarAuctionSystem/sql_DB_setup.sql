DROP TABLE buyer;
DROP TABLE seller;
DROP TABLE car;
DROP TABLE buyer_car;

CREATE TABLE buyer(
   id			INT GENERATED ALWAYS AS IDENTITY,
   username 	VARCHAR(50),
   password		VARCHAR(50),
   firstname	VARCHAR(50),
   lastname		VARCHAR(50),
   phoneno		INT,
   PRIMARY KEY (id)
);

CREATE TABLE seller(
   id			INT GENERATED ALWAYS AS IDENTITY,
   username 	VARCHAR(50),
   password		VARCHAR(50),
   address		VARCHAR(50),
   PRIMARY KEY (id)
);

CREATE TABLE car(
   id			INT GENERATED ALWAYS AS IDENTITY,
   sellerID		INT,
   regno	 	VARCHAR(50),
   make			VARCHAR(50),
   model		VARCHAR(50),
   year 		INT,
   price		FLOAT,
   salesdate	DATE,
   currentbid	FLOAT,
   PRIMARY KEY (id),
   FOREIGN KEY (sellerID) REFERENCES seller (id)
);

CREATE TABLE buyer_car(
	buyerID		INT,
	carID		INT,
	FOREIGN KEY (buyerID) REFERENCES buyer (id),
	FOREIGN KEY (carID) REFERENCES car (id)
);