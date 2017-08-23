DROP TABLE IF EXISTS users;
CREATE TABLE IF NOT EXISTS users(
    username    TEXT       NOT_NULL  UNIQUE  COLLATE NOCASE,
    userId      INTEGER    PRIMARY KEY  AUTOINCREMENT,
    name        TEXT       NOT_NULL,
    surname     TEXT       NOT_NULL,
    dob         TEXT       NOT_NULL,
    phoneNo     TEXT,
    address     TEXT
);

INSERT INTO users(username, name, surname, dob, phoneNo, address) VALUES
-- User 1 --
("jdoe", "John", "Doe", "1925-03-12", "693 5001 982", "10, Doe Street"),
-- User 2 --
("jadoe", "Jane", "Doe", "1997-08-20", NULL, NULL),
-- User 3 --
("cdjoe", "Chris", "Doejoe", "1987-04-23", "(+30) 697 1234 421", NULL),
-- User 4 --
("jjs", "Jason", "Json", "1999-11-01", NULL, "Spartis 31"),
-- User 5 --
("droe", "Doe", "Roe", "2005-01-10", "911", "Peloponisou 13"),
-- User 6 --
("jdoep1", "Jim", "Doepoulos", "1965-08-30", "697 8585 146", NULL),
-- User 7 --
("janedoep", "Jane", "Doepoulos", "1957-02-21", NULL, "Sintagma"),
-- User 8 --
("jj123", "John", "John", "1989-06-07", NULL, NULL),
-- User 9 --
("ja2", "Jason", "Jasonopoulos", "1986-12-17", NULL, "Spartiaton 82"),
-- User 10 --
("droep2", "Doe", "Roepoulos", "1992-05-15", NULL, NULL),
-- User 11 --
("jdoelog", "John", "Doeloglou", "1961-11-14", NULL, NULL),
-- User 12 --
("aserj", "Jane", "Doeloglou", "1979-09-06", NULL, NULL),
-- User 13 --
("done", "Don", "Doe", "1983-04-14", "(+30) 694 5674 190", "Asomatwn 32"),
-- User 14 --
("j2kis", "Jason", "Jsonakis", "1995-05-16", NULL, "Papaflessa 144"),
-- User 15 --
("doeroe", "Doe", "Roedakis", "1958-01-31", NULL, NULL),
-- User 16 --
("jdkis", "John", "Doedakis", "1967-04-12", NULL, NULL),
-- User 17 --
("jd78", "Jane", "Doedakis", "1978-03-10", NULL, NULL),
-- User 18 --
("cdoe66", "Chris", "Doe", "1966-07-18", "210 5678 450", "Troon 52"),
-- User 19 --
("jjsndis", "Jason", "Jsonidis", "1991-04-15", NULL, NULL),
-- User 20 --
("doe123", "Doe", "Roeidis", "1992-07-08", "210 5467 850", "Patreos 54");
