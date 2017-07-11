DROP TABLE IF EXISTS users;
CREATE TABLE IF NOT EXISTS users(
    username    TEXT        NOT_NULL UNIQUE,
    userId      INTEGER     PRIMARY KEY AUTOINCREMENT,
    name        TEXT        NOT_NULL,
    surname     TEXT        NOT_NULL,
    dob         TEXT        NOT_NULL,
    phoneNo     TEXT,
    address     TEXT
);

BEGIN TRANSACTION;
-- User 0 --
INSERT INTO users(username, name, surname, dob, phoneNo, address)
VALUES ("jdoe", "John", "Doe", "1925-03-12", "693 5001 982", "10, Doe Street");
-- User 1 --
INSERT INTO users(username, name, surname, dob, phoneNo, address)
VALUES ("jadoe", "Jane", "Doe", "1997-08-20", NULL, NULL);
-- User 2 --
INSERT INTO users(username, name, surname, dob, phoneNo, address)
VALUES ("cdjoe", "Chris", "Doejoe", "1987-04-23", "(+30) 697 1234 421", NULL);
-- User 3 --
INSERT INTO users(username, name, surname, dob, phoneNo, address)
VALUES ("jjs", "Jason", "Json", "1999-11-01", NULL, "Spartis 31");
-- User 4 --
INSERT INTO users(username, name, surname, dob, phoneNo, address)
VALUES ("droe", "Doe", "Roe", "2005-01-10", "911", "Peloponisou 13");
-- User 5 --
INSERT INTO users(username, name, surname, dob, phoneNo, address)
VALUES ("jdoep1", "Jim", "Doepoulos", "1965-08-30", "697 8585 146", NULL);
-- User 6 --
INSERT INTO users(username, name, surname, dob, phoneNo, address)
VALUES ("janedoep", "Jane", "Doepoulos", "1957-02-21", NULL, "Sintagma");
-- User 7 --
INSERT INTO users(username, name, surname, dob, phoneNo, address)
VALUES ("jj123", "John", "John", "1989-06-07", NULL, NULL);
-- User 8 --
INSERT INTO users(username, name, surname, dob, phoneNo, address)
VALUES ("ja2", "Jason", "Jasonopoulos", "1986-12-17", NULL, "Spartiaton 82");
-- User 9 --
INSERT INTO users(username, name, surname, dob, phoneNo, address)
VALUES ("droep2", "Doe", "Roepoulos", "1992-05-15", NULL, NULL);
-- User 10 --
INSERT INTO users(username, name, surname, dob, phoneNo, address)
VALUES ("jdoelog", "John", "Doeloglou", "1961-11-14", NULL, NULL);
-- User 11 --
INSERT INTO users(username, name, surname, dob, phoneNo, address)
VALUES ("aserj", "Jane", "Doeloglou", "1979-09-06", NULL, NULL);
-- User 12 --
INSERT INTO users(username, name, surname, dob, phoneNo, address)
VALUES ("done", "Don", "Doe", "1983-04-14", "(+30) 694 5674 190", "Asomatwn 32");
-- User 13 --
INSERT INTO users(username, name, surname, dob, phoneNo, address)
VALUES ("j2kis", "Jason", "Jsonakis", "1995-05-16", NULL, "Papaflessa 144");
-- User 14 --
INSERT INTO users(username, name, surname, dob, phoneNo, address)
VALUES ("doeroe", "Doe", "Roedakis", "1958-01-31", NULL, NULL);
-- User 15 --
INSERT INTO users(username, name, surname, dob, phoneNo, address)
VALUES ("jdkis", "John", "Doedakis", "1967-04-12", NULL, NULL);
-- User 16 --
INSERT INTO users(username, name, surname, dob, phoneNo, address)
VALUES ("jd78", "Jane", "Doedakis", "1978-03-10", NULL, NULL);
-- User 17 --
INSERT INTO users(username, name, surname, dob, phoneNo, address)
VALUES ("cdoe66", "Chris", "Doe", "1966-07-18", "210 5678 450", "Troon 52");
-- User 18 --
INSERT INTO users(username, name, surname, dob, phoneNo, address)
VALUES ("jjsndis", "Jason", "Jsonidis", "1991-04-15", NULL, NULL);
-- User 19 --
INSERT INTO users(username, name, surname, dob, phoneNo, address)
VALUES ("doe123", "Doe", "Roeidis", "1992-07-08", "210 5467 850", "Patreos 54");
COMMIT;
