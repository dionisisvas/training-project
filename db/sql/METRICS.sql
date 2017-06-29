DROP TABLE IF EXISTS METRICS;
CREATE TABLE IF NOT EXISTS METRICS(
	height		Boolean,
	weight  	Boolean,
	nationality	TEXT,
	place_of_birth TEXT,
	education TEXT,
	metricsId   INTEGER PRIMARY KEY AUTOINCREMENT,
	userID INTEGER,
	FOREIGN KEY (userID) REFERENCES USERS(userID)
);

BEGIN TRANSACTION;
INSERT INTO METRICS(height, weight, nationality,place_of_birth,userID,education)
VALUES (1.75, 75, "GREEk","Athens",0,"University Education");

INSERT INTO METRICS(height, weight, nationality,place_of_birth,userID,education)
VALUES (1.85, 80, "ITALIAN","Rome",1,"University Education");

INSERT INTO METRICS(height, weight, nationality,place_of_birth,userID,education)
VALUES (1.80, 95, "ITALIAN","Torino",2,"High School Diploma");

INSERT INTO METRICS(height, weight, nationality,place_of_birth,userID,education)
VALUES (1.85, 85, "GERMAN","Berlin",3,"Doctorate Degree");

INSERT INTO METRICS(height, weight, nationality,place_of_birth,userID,education)
VALUES (1.65, 75, "GREEK","Crete",4,"High School Diploma");

INSERT INTO METRICS(height, weight, nationality,place_of_birth,userID,education)
VALUES (1.85, 90, "SERBIAN","Berlin",5,"Master's Degree");

INSERT INTO METRICS(height, weight, nationality,place_of_birth,userID,education)
VALUES (1.67,86, "TURKISH","Paris",6,"No High School Diploma");

INSERT INTO METRICS(height, weight, nationality,place_of_birth,userID,education)
VALUES (1.78, 90, "BULGARIAN","Sofia",7,"High School Diploma");

INSERT INTO METRICS(height, weight, nationality,place_of_birth,userID,education)
VALUES (1.77, 86, "U.S.A","L.A",8,"Doctorate Degree");

INSERT INTO METRICS(height, weight, nationality,place_of_birth,userID,education)
VALUES (1.78, 88, "U.S.A","New York",9,"Doctorate Degree");

INSERT INTO METRICS(height, weight, nationality,place_of_birth,userID,education)
VALUES (1.73, 87, "U.S.A","Florida",10,"Master's Degree");

INSERT INTO METRICS(height, weight, nationality,place_of_birth,userID,education)
VALUES (1.74, 84, "U.S.A","L.A",11,"High School Diploma");

INSERT INTO METRICS(height, weight, nationality,place_of_birth,userID,education)
VALUES (1.78, 87, "U.S.A","Texas",12,"Professional Degree");

INSERT INTO METRICS(height, weight, nationality,place_of_birth,userID,education)
VALUES (1.78, 87, "U.S.A","London",13,"No High School Diploma");

INSERT INTO METRICS(height, weight, nationality,place_of_birth,userID,education)
VALUES (1.97, 97, "GREEK","London",14,"Master's Degree");

COMMIT;