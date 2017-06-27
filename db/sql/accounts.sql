DROP TABLE IF EXISTS accounts;
CREATE TABLE IF NOT EXISTS accounts(
    userId      INTEGER     NOT_NULL UNIQUE,
    username    TEXT        NOT_NULL UNIQUE,
    password    TEXT        NOT_NULL,
 	FOREIGN KEY (userId) REFERENCES users(userId)   
);

BEGIN TRANSACTION;
-- User 0 --
INSERT INTO accounts(userId, username, password)
VALUES (1, "jdoe",  "password1");
-- User 1 --
INSERT INTO accounts(userId, username, password)
VALUES (2, "jadoe",  "password2");
-- User 2 --
INSERT INTO accounts(userId, username, password)
VALUES (3, "cdjoe",  "password3");
-- User 3 --
INSERT INTO accounts(userId, username, password)
VALUES (4, "jjs",  "password4");
-- User 4 --
INSERT INTO accounts(userId, username, password)
VALUES (5, "droe",  "password5");
-- User 5 --
INSERT INTO accounts(userId, username, password)
VALUES (6, "jdoep1",  "password6");
-- User 6 --
INSERT INTO accounts(userId, username, password)
VALUES (7, "janedoep",  "password7");
-- User 7 --
INSERT INTO accounts(userId, username, password)
VALUES (8, "jj123",  "password8");
-- User 8 --
INSERT INTO accounts(userId, username, password)
VALUES (9, "ja2",  "password9");
-- User 9 --
INSERT INTO accounts(userId, username, password)
VALUES (10, "droep2",  "password10");
-- User 10 --
INSERT INTO accounts(userId, username, password)
VALUES (11, "jdoelog",  "password11");
-- User 11 --
INSERT INTO accounts(userId, username, password)
VALUES (12, "aserj",  "password12");
-- User 12 --
INSERT INTO accounts(userId, username, password)
VALUES (13, "done",  "password13");
-- User 13 --
INSERT INTO accounts(userId, username, password)
VALUES (14, "j2kis",  "password14");
-- User 14 --
INSERT INTO accounts(userId, username, password)
VALUES (15, "doeroe",  "password15");
-- User 15 --
INSERT INTO accounts(userId, username, password)
VALUES (16, "jdkis",  "password16");
-- User 16 --
INSERT INTO accounts(userId, username, password)
VALUES (17, "jd78",  "password17");
-- User 17 --
INSERT INTO accounts(userId, username, password)
VALUES (18, "cdoe66",  "password18");
-- User 18 --
INSERT INTO accounts(userId, username, password)
VALUES (19, "jjsndis",  "password19");
-- User 19 --
INSERT INTO accounts(userId, username, password)
VALUES (120, "doe123",  "password20");
COMMIT;
