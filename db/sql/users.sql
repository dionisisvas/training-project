DROP TABLE IF EXISTS users;
CREATE TABLE IF NOT EXISTS users(
	username   	 TEXT       UNIQUE,	
	userId 	  	 INTEGER,
	name      	 TEXT		NOT_NULL,
	surname   	 TEXT		NOT_NULL,
	dob       	 TEXT,
	phoneNo      TEXT,
	address   	 TEXT,
	password  	 TEXT, -- Safety above all
	PRIMARY KEY (userId)
);

BEGIN TRANSACTION;
-- User 0 --
INSERT INTO users(username, userId, name, surname, dob, phoneNo, address, password)
VALUES (NULL, 0, "John", "Doe", "1925-03-12", "693 5001 982", "10, Doe Street", NULL);
-- User 1 --
INSERT INTO users(username, userId, name, surname, dob, phoneNo, address, password)
VALUES (NULL, 1, "Jane", "Doe", "1997-08-20", NULL, NULL, NULL);
-- User 2 --
INSERT INTO users(username, userId, name, surname, dob, phoneNo, address, password)
VALUES (NULL, 2, "Chris", "Doejoe", "1987-04-23", "(+30) 697 1234 421", NULL, NULL);
-- User 3 --
INSERT INTO users(username, userId, name, surname, dob, phoneNo, address, password)
VALUES (NULL, 3, "Jason", "Json", "1999-11-01", NULL, "Spartis 31", NULL);
-- User 4 --
INSERT INTO users(username, userId, name, surname, dob, phoneNo, address, password)
VALUES (NULL, 4, "Doe", "Roe", "2005-01-10", "911", "Peloponisou 13", NULL);
-- User 5 --
INSERT INTO users(username, userId, name, surname, dob, phoneNo, address, password)
VALUES (NULL, 5, "Jim", "Doepoulos", "1965-08-30", "697 8585 146", NULL, NULL);
-- User 6 --
INSERT INTO users(username, userId, name, surname, dob, phoneNo, address, password)
VALUES (NULL, 6, "Jane", "Doepoulos", "1957-02-21", NULL, "Sintagma", NULL);
-- User 7 --
INSERT INTO users(username, userId, name, surname, dob, phoneNo, address, password)
VALUES (NULL, 7, "John", "John", "1989-06-07", NULL, NULL, NULL);
-- User 8 --
INSERT INTO users(username, userId, name, surname, dob, phoneNo, address, password)
VALUES (NULL, 8, "Jason", "Jasonopoulos", "1986-12-17", NULL, "Spartiaton 82", NULL);
-- User 9 --
INSERT INTO users(username, userId, name, surname, dob, phoneNo, address, password)
VALUES (NULL, 9, "Doe", "Roepoulos", "1992-05-15", NULL, NULL, NULL);
-- User 10 --
INSERT INTO users(username, userId, name, surname, dob, phoneNo, address, password)
VALUES (NULL, 10, "John", "Doeloglou", "1961-11-14", NULL, NULL, NULL);
-- User 11 --
INSERT INTO users(username, userId, name, surname, dob, phoneNo, address, password)
VALUES (NULL, 11, "Jane", "Doeloglou", "1979-09-06", NULL, NULL, NULL);
-- User 12 --
INSERT INTO users(username, userId, name, surname, dob, phoneNo, address, password)
VALUES (NULL, 12, "Don", "Doe", "1983-04-14", "(+30) 694 5674 190", "Asomatwn 32", NULL);
-- User 13 --
INSERT INTO users(username, userId, name, surname, dob, phoneNo, address, password)
VALUES (NULL, 13, "Jason", "Jsonakis", "1995-05-16", NULL, "Papaflessa 144", NULL);
-- User 14 --
INSERT INTO users(username, userId, name, surname, dob, phoneNo, address, password)
VALUES (NULL, 14, "Doe", "Roedakis", "1958-01-31", NULL, NULL, NULL);
-- User 15 --
INSERT INTO users(username, userId, name, surname, dob, phoneNo, address, password)
VALUES (NULL, 15, "John", "Doedakis", "1967-04-12", NULL, NULL, NULL);
-- User 16 --
INSERT INTO users(username, userId, name, surname, dob, phoneNo, address, password)
VALUES (NULL, 16, "Jane", "Doedakis", "1978-03-10", NULL, NULL, NULL);
-- User 17 --
INSERT INTO users(username, userId, name, surname, dob, phoneNo, address, password)
VALUES (NULL, 17, "Chris", "Doe", "1966-07-18", "210 5678 450", "Troon 52", NULL);
-- User 18 --
INSERT INTO users(username, userId, name, surname, dob, phoneNo, address, password)
VALUES (NULL, 18, "Jason", "Jsonidis", "1991-04-15", NULL, NULL, NULL);
-- User 19 --
INSERT INTO users(username, userId, name, surname, dob, phoneNo, address, password)
VALUES (NULL, 19, "Doe", "Roeidis", "1992-07-08", "210 5467 850", "Patreos 54", NULL);
COMMIT;
