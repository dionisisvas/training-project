DROP TABLE IF EXISTS METRICS;
CREATE TABLE IF NOT EXISTS METRICS(
	height		Boolean,
	weight  	Boolean,
	nationality	TEXT,
	place_of_birth TEXT,
	education TEXT,
	metricsId   INTEGER PRIMARY KEY AUTOINCREMENT,
	userId INTEGER,
	FOREIGN KEY (userId) REFERENCES USERS(userId)
);

BEGIN TRANSACTION;

INSERT INTO METRICS(height, weight, nationality,place_of_birth,userId,education)
VALUES (1.85, 80, "ITALY","Rome",1,"University Education");

INSERT INTO METRICS(height, weight, nationality,place_of_birth,userId,education)
VALUES (1.80, 95, "ITALY","Torino",2,"High School Diploma");

INSERT INTO METRICS(height, weight, nationality,place_of_birth,userId,education)
VALUES (1.85, 85, "GERMANY","Berlin",3,"Doctorate Degree");

INSERT INTO METRICS(height, weight, nationality,place_of_birth,userId,education)
VALUES (1.65, 75, "GREECE","Crete",4,"High School Diploma");

INSERT INTO METRICS(height, weight, nationality,place_of_birth,userId,education)
VALUES (1.85, 90, "SERBIA","Berlin",5,"Master's Degree");

INSERT INTO METRICS(height, weight, nationality,place_of_birth,userId,education)
VALUES (1.67,86, "TURKEY","Paris",6,"No High School Diploma");

INSERT INTO METRICS(height, weight, nationality,place_of_birth,userId,education)
VALUES (1.78, 90, "BULGARIA","Sofia",7,"High School Diploma");

INSERT INTO METRICS(height, weight, nationality,place_of_birth,userId,education)
VALUES (1.77, 86, "U.S.A","L.A",8,"Doctorate Degree");

INSERT INTO METRICS(height, weight, nationality,place_of_birth,userId,education)
VALUES (1.78, 88, "U.S.A","New York",9,"Doctorate Degree");

INSERT INTO METRICS(height, weight, nationality,place_of_birth,userId,education)
VALUES (1.73, 87, "MEXICO","Florida",10,"Master's Degree");

INSERT INTO METRICS(height, weight, nationality,place_of_birth,userId,education)
VALUES (1.74, 84, "U.S.A","L.A",11,"High School Diploma");

INSERT INTO METRICS(height, weight, nationality,place_of_birth,userId,education)
VALUES (1.78, 87, "U.S.A","Texas",12,"Professional Degree");

INSERT INTO METRICS(height, weight, nationality,place_of_birth,userId,education)
VALUES (1.78, 87, "BRAZIL","London",13,"No High School Diploma");

INSERT INTO METRICS(height, weight, nationality,place_of_birth,userId,education)
VALUES (1.97, 97, "GREECE","London",14,"Master's Degree");

INSERT INTO METRICS(height, weight, nationality,place_of_birth,userId,education)
VALUES (1.73, 87, "FRANCE","Lyon",15,"Master's Degree");

INSERT INTO METRICS(height, weight, nationality,place_of_birth,userId,education)
VALUES (1.74, 84, "CANADA","New York",16,"High School Diploma");

INSERT INTO METRICS(height, weight, nationality,place_of_birth,userId,education)
VALUES (1.84, 97, "U.S.A","Texas",17,"Professional Degree");

INSERT INTO METRICS(height, weight, nationality,place_of_birth,userId,education)
VALUES (1.78, 87, "RUSSIA","Liverpool",18,"No High School Diploma");

INSERT INTO METRICS(height, weight, nationality,place_of_birth,userId,education)
VALUES (1.97, 97, "GREECE","London",19,"Master's Degree");

INSERT INTO METRICS(height, weight, nationality,place_of_birth,userId,education)
VALUES (1.86, 60, "ITALY","Milan",20,"Professional Degree");
COMMIT;