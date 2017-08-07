DROP TABLE IF EXISTS accounts;
CREATE TABLE IF NOT EXISTS accounts(
    accountId   INTEGER     PRIMARY KEY AUTOINCREMENT,
    username    TEXT        NOT_NULL UNIQUE,
    password    TEXT        NOT_NULL,
    email       TEXT        NOT_NULL UNIQUE
);

BEGIN TRANSACTION;
-- User 0 --
INSERT INTO accounts(username, password, email)
VALUES ("jdoe",  "password1", "testmail1@t-mail.com");
-- User 1 --
INSERT INTO accounts(username, password, email)
VALUES ("jadoe",  "password2", "testmail2@t-mail.com");
-- User 2 --
INSERT INTO accounts(username, password, email)
VALUES ("cdjoe",  "password3", "testmail3@t-mail.com");
-- User 3 --
INSERT INTO accounts(username, password, email)
VALUES ("jjs",  "password4", "testmail4@t-mail.com");
-- User 4 --
INSERT INTO accounts(username, password, email)
VALUES ("droe",  "password5", "testmail5@t-mail.com");
-- User 5 --
INSERT INTO accounts(username, password, email)
VALUES ("jdoep1",  "password6", "testmail6@t-mail.com");
-- User 6 --
INSERT INTO accounts(username, password, email)
VALUES ("janedoep",  "password7", "testmail7@t-mail.com");
-- User 7 --
INSERT INTO accounts(username, password, email)
VALUES ("jj123",  "password8", "testmail8@t-mail.com");
-- User 8 --
INSERT INTO accounts(username, password, email)
VALUES ("ja2",  "password9", "testmail9@t-mail.com");
-- User 9 --
INSERT INTO accounts(username, password, email)
VALUES ("droep2",  "password10", "testmail10@t-mail.com");
-- User 10 --
INSERT INTO accounts(username, password, email)
VALUES ("jdoelog",  "password11", "testmail11@t-mail.com");
-- User 11 --
INSERT INTO accounts(username, password, email)
VALUES ("aserj",  "password12", "testmail12@t-mail.com");
-- User 12 --
INSERT INTO accounts(username, password, email)
VALUES ("done",  "password13", "testmail13@t-mail.com");
-- User 13 --
INSERT INTO accounts(username, password, email)
VALUES ("j2kis",  "password14", "testmail14@t-mail.com");
-- User 14 --
INSERT INTO accounts(username, password, email)
VALUES ("doeroe",  "password15", "testmail15@t-mail.com");
-- User 15 --
INSERT INTO accounts(username, password, email)
VALUES ("jdkis",  "password16", "testmail16@t-mail.com");
-- User 16 --
INSERT INTO accounts(username, password, email)
VALUES ("jd78",  "password17", "testmail17@t-mail.com");
-- User 17 --
INSERT INTO accounts(username, password, email)
VALUES ("cdoe66",  "password18", "testmail18@t-mail.com");
-- User 18 --
INSERT INTO accounts(username, password, email)
VALUES ("jjsndis",  "password19", "testmail19@t-mail.com");
-- User 19 --
INSERT INTO accounts(username, password, email)
VALUES ("doe123",  "password20", "testmail20@t-mail.com");
COMMIT;
