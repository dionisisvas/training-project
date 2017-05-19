DROP TABLE IF EXISTS USERS;
CREATE TABLE IF NOT EXISTS USERS(
	usrname   	 TEXT       UNIQUE,	
	usrID 	  	 INTEGER,
	name      	 TEXT		NOT_NULL,
	surname   	 TEXT		NOT_NULL,
	age       	 INTEGER,
	phone     	 TEXT		UNIQUE,
	address   	 TEXT,
	password  	 TEXT, -- Safety above all
	PRIMARY KEY (usrID)
);

BEGIN TRANSACTION;
-- User 0 --
INSERT INTO USERS(usrname, usrID, name, surname, age, phone, address, password)
VALUES (NULL, 0, "John", "Doe", 25, "693 5001 982", "10, Doe Street", NULL);
-- User 1 --
INSERT INTO USERS(usrname, usrID, name, surname, age, phone, address, password)
VALUES (NULL, 1, "Jane", "Doe", NULL, NULL, NULL, NULL);
-- User 2 --
INSERT INTO USERS(usrname, usrID, name, surname, age, phone, address, password)
VALUES (NULL, 2, "Chris", "Doejoe", 16, "(+30) 697 1234 421", NULL, NULL);
-- User 3 --
INSERT INTO USERS(usrname, usrID, name, surname, age, phone, address, password)
VALUES (NULL, 3, "Jason", "Json", 7, NULL, "Spartis 31", NULL);
-- User 4 --
INSERT INTO USERS(usrname, usrID, name, surname, age, phone, address, password)
VALUES (NULL, 4, "Doe", "Roe", 100, "911", "Peloponisou 13", NULL);
-- User 5 --
INSERT INTO USERS(usrname, usrID, name, surname, age, phone, address, password)
VALUES (NULL, 5, "Jim", "Doepoulos", 27, "697 8585 146", NULL, NULL);
-- User 6 --
INSERT INTO USERS(usrname, usrID, name, surname, age, phone, address, password)
VALUES (NULL, 6, "Jane", "Doepoulos", 22, NULL, "Sintagma", NULL);
-- User 7 --
INSERT INTO USERS(usrname, usrID, name, surname, age, phone, address, password)
VALUES (NULL, 7, "John", "John", 44, NULL, NULL, NULL);
-- User 8 --
INSERT INTO USERS(usrname, usrID, name, surname, age, phone, address, password)
VALUES (NULL, 8, "Jason", "Jasonopoulos", 19, NULL, "Spartiaton 82", NULL);
-- User 9 --
INSERT INTO USERS(usrname, usrID, name, surname, age, phone, address, password)
VALUES (NULL, 9, "Doe", "Roepoulos", 17, NULL, NULL, NULL);
-- User 10 --
INSERT INTO USERS(usrname, usrID, name, surname, age, phone, address, password)
VALUES (NULL, 10, "John", "Doeloglou", NULL, NULL, NULL, NULL);
-- User 11 --
INSERT INTO USERS(usrname, usrID, name, surname, age, phone, address, password)
VALUES (NULL, 11, "Jane", "Doeloglou", 62, NULL, NULL, NULL);
-- User 12 --
INSERT INTO USERS(usrname, usrID, name, surname, age, phone, address, password)
VALUES (NULL, 12, "Don", "Doe", 33, "(+30) 694 5674 190", "Asomatwn 32", NULL);
-- User 13 --
INSERT INTO USERS(usrname, usrID, name, surname, age, phone, address, password)
VALUES (NULL, 13, "Jason", "Jsonakis", 91, NULL, "Papaflessa 144", NULL);
-- User 14 --
INSERT INTO USERS(usrname, usrID, name, surname, age, phone, address, password)
VALUES (NULL, 14, "Doe", "Roedakis", 22, NULL, NULL, NULL);
-- User 15 --
INSERT INTO USERS(usrname, usrID, name, surname, age, phone, address, password)
VALUES (NULL, 15, "John", "Doedakis",15, NULL, NULL, NULL);
-- User 16 --
INSERT INTO USERS(usrname, usrID, name, surname, age, phone, address, password)
VALUES (NULL, 16, "Jane", "DoeDAKIS", 21, NULL, NULL, NULL);
-- User 17 --
INSERT INTO USERS(usrname, usrID, name, surname, age, phone, address, password)
VALUES (NULL, 17, "Chris", "Doe", 24, "210 5678 450", "Troon 52", NULL);
-- User 18 --
INSERT INTO USERS(usrname, usrID, name, surname, age, phone, address, password)
VALUES (NULL, 18, "Jason", "Jsonidis", 35, NULL, NULL, NULL);
-- User 19 --
INSERT INTO USERS(usrname, usrID, name, surname, age, phone, address, password)
VALUES (NULL, 19, "Doe", "Roeidis", 16, "210 5467 850", "Patreos 54", NULL);
COMMIT;