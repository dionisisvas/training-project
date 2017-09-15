DROP TABLE IF EXISTS users;
CREATE TABLE IF NOT EXISTS users(
    id                INTEGER    PRIMARY KEY  AUTOINCREMENT,
    name              TEXT       NOT_NULL,
    surname           TEXT       NOT_NULL,
    date_of_birth     TEXT       NOT_NULL,
    place_of_birth    TEXT,
    nationality       TEXT,
    phone_no          INTEGER,
    address           TEXT,
    height            REAL,
    weight            REAL
);

INSERT INTO users(name, surname, date_of_birth, place_of_birth, nationality, phone_no, address, height, weight) VALUES
-- User 1 --
("John", "Pappas", "1985-03-12", "Athens, Attiki, Greece", "GR", 5935001982, "10, Igiou St, 11851 Athens", 1.80, 85.),
-- User 2 --
("Jane", "Slater", "1992-08-20", "New York, NY, United States of America", "USA",  3060231450, NULL, 1.70, 54.),
-- User 3 --
("Chris", "Giannakopoulos", "1987-04-23", NULL, NULL, NULL, NULL, NULL, NULL),
-- User 4 --
("Jason", "Brown", "1979-11-01", "Austin, TX, United States of America", "USA",  NULL, "3050, Tamarron Blvd, TX 78746 Austin", 1.76, 97.),
-- User 5 --
("Zoe", "Anastasopoulou", "1998-01-10", "Patras, Achaia, Greece", "GR",  4356412289, "13, Gorgopotamou St, 26332 Patras", 1.80, 85.),
-- User 6 --
("Jim", "Derulo", "1965-08-30", "Monza, Lombardy, Italy", "IT",  NULL, NULL, 1.67, 66.),
-- User 7 --
("Mairy", "Abraham", "1957-02-21", "Toronto, Ontario, Canada", "CA",  NULL, NULL, NULL, NULL),
-- User 8 --
("John", "Pantelis", "1989-06-07", "Athens, Attiki, Greece", "GR",  2971234421, NULL, 1.82, 81.),
-- User 9 --
("Giorgio", "Mancini", "1986-12-17", NULL,  NULL, "IT", NULL, NULL, NULL),
-- User 10 --
("Panos", "Dimitrakakis", "1992-05-15", "Thessaloniki, Thessaloniki, Greece", "GR",  NULL, NULL, 2.01, 97.),
-- User 11 --
("Konstantinos", "Athanasiou", "1961-11-14", "Athens, Attiki, Greece", "GR", 3255409520, "47, Agiou Georgiou St, 54635 Thessaloniki", NULL, NULL),
-- User 12 --
("Jenny", "Mitropoulou", "1979-09-06", "Athens, Attiki, Greece", "GR",  NULL, NULL, 1.77, NULL),
-- User 13 --
("Don", "Lewis", "1983-04-14", "Salt Lake City, UT, United States of America", "USA",  5463120847, "1535, Brava St, UT 84104 Salt Lake City", 1.95, 118.),
-- User 14 --
("Bill", "Romero", "1995-05-16", "Imola, Emilia-Romagna, Italy", "IT",  NULL, "4, Via Cantoncello, 40026 Imola", 1.80, 85.),
-- User 15 --
("Heather", "Paxton", "1968-01-31", NULL,  NULL, NULL, NULL, NULL, NULL),
-- User 16 --
("John", "Papadopoulos", "1967-04-12", "Volos, Magnesia, Greece", "GR",  NULL, NULL, 1.88, 95.),
-- User 17 --
("Dimitra", "Georgiou", "1988-03-10", "Ioannina, Ioannina, Greece", "GR",  NULL, NULL, 1.56, 43.),
-- User 18 --
("Andrew", "Trulli", "1993-07-18", NULL, "SCT", 5421709432, "71, Mulgrave Rd, Sutton SM2 6LY", NULL, NULL),
-- User 19 --
("Nigel", "Smith", "1991-04-15", "London, London, England", "EN",  NULL, NULL, 1.79, 86.),
-- User 20 --
("Wernher", "Fischer", "1984-07-08", "Hamburg, Hamburg, Germany", "DE",  NULL, "13, Leuthener St, 10829 Berlin", 1.59, 60.);
