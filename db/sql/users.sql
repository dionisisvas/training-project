DROP TABLE IF EXISTS users;
CREATE TABLE IF NOT EXISTS users(
    id                INTEGER    PRIMARY KEY  AUTOINCREMENT,
    name              TEXT       NOT_NULL,
    surname           TEXT       NOT_NULL,
    date_of_birth     TEXT       NOT_NULL,
    place_of_birth    TEXT,
    nationality       TEXT,
    phone_no          TEXT,
    address           TEXT,
    height            REAL,
    weight            REAL
);

INSERT INTO users(name, surname, date_of_birth, place_of_birth, nationality, phone_no, address, height, weight) VALUES
-- User 1 --
("John", "Doe", "1925-03-12", "Athens, Greece", "GR", "693 5001 982", "10, Doe Street", 1.80, 85.),
-- User 2 --
("Jane", "Doe", "1997-08-20", "Athens, Greece", "GR",  NULL, NULL, 1.80, 85.),
-- User 3 --
("Chris", "Doejoe", "1987-04-23", "Athens, Greece", "GR",  "(+30) 697 1234 421", NULL, 1.80, 85.),
-- User 4 --
("Jason", "Json", "1999-11-01", "Athens, Greece", "GR",  NULL, "Spartis 31", 1.80, 85.),
-- User 5 --
("Doe", "Roe", "2005-01-10", "Athens, Greece", "GR",  "911", "Peloponisou 13", 1.80, 85.),
-- User 6 --
("Jim", "Doepoulos", "1965-08-30", "Athens, Greece", "GR",  "697 8585 146", NULL, 1.80, 85.),
-- User 7 --
("Jane", "Doepoulos", "1957-02-21", "Athens, Greece", "GR",  NULL, "Sintagma", 1.80, 85.),
-- User 8 --
("John", "John", "1989-06-07", "Athens, Greece", "GR",  NULL, NULL, 1.80, 85.),
-- User 9 --
("Jason", "Jasonopoulos", "1986-12-17", "Athens, Greece", "GR",  NULL, "Spartiaton 82", 1.80, 85.),
-- User 10 --
("Doe", "Roepoulos", "1992-05-15", "Athens, Greece", "GR",  NULL, NULL, 1.80, 85.),
-- User 11 --
("John", "Doeloglou", "1961-11-14", "Athens, Greece", "GR",  NULL, NULL, 1.80, 85.),
-- User 12 --
("Jane", "Doeloglou", "1979-09-06", "Athens, Greece", "GR",  NULL, NULL, 1.80, 85.),
-- User 13 --
("Don", "Doe", "1983-04-14", "Athens, Greece", "GR",  "(+30) 694 5674 190", "Asomatwn 32", 1.80, 85.),
-- User 14 --
("Jason", "Jsonakis", "1995-05-16", "Athens, Greece", "GR",  NULL, "Papaflessa 144", 1.80, 85.),
-- User 15 --
("Doe", "Roedakis", "1958-01-31", "Athens, Greece", "GR",  NULL, NULL, 1.80, 85.),
-- User 16 --
("John", "Doedakis", "1967-04-12", "Athens, Greece", "GR",  NULL, NULL, 1.80, 85.),
-- User 17 --
("Jane", "Doedakis", "1978-03-10", "Athens, Greece", "GR",  NULL, NULL, 1.80, 85.),
-- User 18 --
("Chris", "Doe", "1966-07-18", "Athens, Greece", "GR",  "210 5678 450", "Troon 52", 1.80, 85.),
-- User 19 --
("Jason", "Jsonidis", "1991-04-15", "Athens, Greece", "GR",  NULL, NULL, 1.80, 85.),
-- User 20 --
("Doe", "Roeidis", "1992-07-08", "Athens, Greece", "GR",  "210 5467 850", "Patreos 54", 1.80, 85.);
