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
VALUES (1.85, 80, "ITALY","Biblioteca del Dipartimento di studi politici, Piazzale A. Moro, 5, 00185 Roma RM, Italy",1,"University Education");

INSERT INTO METRICS(height, weight, nationality,place_of_birth,userId,education)
VALUES (1.80, 95, "ITALY","Corso Galileo Ferraris, 130, Turin, Italy, 130",2,"High School Diploma");

INSERT INTO METRICS(height, weight, nationality,place_of_birth,userId,education)
VALUES (1.85, 85, "GERMANY","Lichtenberg,Berlin, Germany",3,"Doctorate Degree");

INSERT INTO METRICS(height, weight, nationality,place_of_birth,userId,education)
VALUES (1.65, 75, "GREECE","Arachovis 35, Athina 106 81, Greece",4,"High School Diploma");

INSERT INTO METRICS(height, weight, nationality,place_of_birth,userId,education)
VALUES (1.85, 90, "SERBIA","10557 Berlin,Germany",5,"Master's Degree");

INSERT INTO METRICS(height, weight, nationality,place_of_birth,userId,education)
VALUES (1.67,86, "TURKEY","Necker,Paris,France",6,"No High School Diploma");

INSERT INTO METRICS(height, weight, nationality,place_of_birth,userId,education)
VALUES (1.78, 90, "BULGARIA","1324 zh.k. Lyulin 7, Sofia, Bulgaria",7,"High School Diploma");

INSERT INTO METRICS(height, weight, nationality,place_of_birth,userId,education)
VALUES (1.77, 86, "U.S.A","Mid City,Los Angeles, CA",8,"Doctorate Degree");

INSERT INTO METRICS(height, weight, nationality,place_of_birth,userId,education)
VALUES (1.78, 88, "U.S.A","New Bedford-Stuyvesant,Brooklyn, NY",9,"Doctorate Degree");

INSERT INTO METRICS(height, weight, nationality,place_of_birth,userId,education)
VALUES (1.73, 87, "MEXICO","Hardee County,Florida",10,"Master's Degree");

INSERT INTO METRICS(height, weight, nationality,place_of_birth,userId,education)
VALUES (1.74, 84, "U.S.A","Reseda, Los Angeles, CA",11,"High School Diploma");

INSERT INTO METRICS(height, weight, nationality,place_of_birth,userId,education)
VALUES (1.78, 87, "U.S.A","Schleicher County,Texas",12,"Professional Degree");

INSERT INTO METRICS(height, weight, nationality,place_of_birth,userId,education)
VALUES (1.78, 87, "BRAZIL","Manor Place Depot,London,UK",13,"No High School Diploma");

INSERT INTO METRICS(height, weight, nationality,place_of_birth,userId,education)
VALUES (1.97, 97, "GREECE","72 Upper Thames St,London,EC4R 3TA,UK",14,"Master's Degree");

INSERT INTO METRICS(height, weight, nationality,place_of_birth,userId,education)
VALUES (1.73, 87, "FRANCE","Victor Bach - St Louis,69007 Lyon,France",15,"Master's Degree");

INSERT INTO METRICS(height, weight, nationality,place_of_birth,userId,education)
VALUES (1.74, 84, "CANADA","Buffalo,New York",16,"High School Diploma");

INSERT INTO METRICS(height, weight, nationality,place_of_birth,userId,education)
VALUES (1.84, 97, "U.S.A","Menard County,Texas",17,"Professional Degree");

INSERT INTO METRICS(height, weight, nationality,place_of_birth,userId,education)
VALUES (1.78, 87, "RUSSIA","300 3rd St,Liverpool, NY 13088",18,"No High School Diploma");

INSERT INTO METRICS(height, weight, nationality,place_of_birth,userId,education)
VALUES (1.97, 97, "GREECE","20 Wallflower St,Shepherd's Bush, London,W12 0TE,UK",19,"Master's Degree");

INSERT INTO METRICS(height, weight, nationality,place_of_birth,userId,education)
VALUES (1.86, 60, "ITALY","San Siro,Milan, Metropolitan City of Milan,Italy",20,"Professional Degree");
COMMIT;