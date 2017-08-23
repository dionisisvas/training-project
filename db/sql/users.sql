DROP TABLE IF EXISTS users;
CREATE TABLE IF NOT EXISTS users(
    userId      INTEGER    PRIMARY KEY  AUTOINCREMENT,
    username    TEXT       NOT_NULL  UNIQUE  COLLATE NOCASE,
    name        TEXT       NOT_NULL,
    surname     TEXT       NOT_NULL,
    dob         TEXT       NOT_NULL,
    phoneNo     TEXT,
    address     TEXT
);

INSERT INTO users(name, surname, dob, phoneNo, address) VALUES
-- User 1 --
("John", "Doe", "1925-03-12", "693 5001 982", "10, Doe Street"),
-- User 2 --
("Jane", "Doe", "1997-08-20", NULL, NULL),
-- User 3 --
("Chris", "Doejoe", "1987-04-23", "(+30) 697 1234 421", NULL),
-- User 4 --
("Jason", "Json", "1999-11-01", NULL, "Spartis 31"),
-- User 5 --
("Doe", "Roe", "2005-01-10", "911", "Peloponisou 13"),
-- User 6 --
("Jim", "Doepoulos", "1965-08-30", "697 8585 146", NULL),
-- User 7 --
("Jane", "Doepoulos", "1957-02-21", NULL, "Sintagma"),
-- User 8 --
("John", "John", "1989-06-07", NULL, NULL),
-- User 9 --
("Jason", "Jasonopoulos", "1986-12-17", NULL, "Spartiaton 82"),
-- User 10 --
("Doe", "Roepoulos", "1992-05-15", NULL, NULL),
-- User 11 --
("John", "Doeloglou", "1961-11-14", NULL, NULL),
-- User 12 --
("Jane", "Doeloglou", "1979-09-06", NULL, NULL),
-- User 13 --
("Don", "Doe", "1983-04-14", "(+30) 694 5674 190", "Asomatwn 32"),
-- User 14 --
("Jason", "Jsonakis", "1995-05-16", NULL, "Papaflessa 144"),
-- User 15 --
("Doe", "Roedakis", "1958-01-31", NULL, NULL),
-- User 16 --
("John", "Doedakis", "1967-04-12", NULL, NULL),
-- User 17 --
("Jane", "Doedakis", "1978-03-10", NULL, NULL),
-- User 18 --
("Chris", "Doe", "1966-07-18", "210 5678 450", "Troon 52"),
-- User 19 --
("Jason", "Jsonidis", "1991-04-15", NULL, NULL),
-- User 20 --
("Doe", "Roeidis", "1992-07-08", "210 5467 850", "Patreos 54");
