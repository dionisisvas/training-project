DROP TABLE IF EXISTS accounts;
CREATE TABLE IF NOT EXISTS accounts(
    accountId    INTEGER    PRIMARY KEY,
    username     TEXT       NOT_NULL  UNIQUE  COLLATE NOCASE,
    password     TEXT       NOT_NULL,
    email        TEXT       NOT_NULL  UNIQUE  COLLATE NOCASE,
    FOREIGN KEY (accountId) REFERENCES users(userId)
);

INSERT INTO accounts(accountId, username, password, email) VALUES
-- User 1 --
(1, "jdoe",  "password1", "testmail1@t-mail.com"),
-- User 2 --
(2, "jadoe",  "password2", "testmail2@t-mail.com"),
-- User 3 --
(3, "cdjoe",  "password3", "testmail3@t-mail.com"),
-- User 4 --
(4, "jjs",  "password4", "testmail4@t-mail.com"),
-- User 5 --
(5, "droe",  "password5", "testmail5@t-mail.com"),
-- User 6 --
(6, "jdoep1",  "password6", "testmail6@t-mail.com"),
-- User 7 --
(7, "janedoep",  "password7", "testmail7@t-mail.com"),
-- User 8 --
(8, "jj123",  "password8", "testmail8@t-mail.com"),
-- User 9 --
(9, "ja2",  "password9", "testmail9@t-mail.com"),
-- User 10 --
(10, "droep2",  "password10", "testmail10@t-mail.com"),
-- User 11 --
(11, "jdoelog",  "password11", "testmail11@t-mail.com"),
-- User 12 --
(12, "aserj",  "password12", "testmail12@t-mail.com"),
-- User 13 --
(13, "done",  "password13", "testmail13@t-mail.com"),
-- User 14 --
(14, "j2kis",  "password14", "testmail14@t-mail.com"),
-- User 15 --
(15, "doeroe",  "password15", "testmail15@t-mail.com"),
-- User 16 --
(16, "jdkis",  "password16", "testmail16@t-mail.com"),
-- User 17 --
(17, "jd78",  "password17", "testmail17@t-mail.com"),
-- User 18 --
(18, "cdoe66",  "password18", "testmail18@t-mail.com"),
-- User 19 --
(19, "jjsndis",  "password19", "testmail19@t-mail.com"),
-- User 20 --
(20, "doe123",  "password20", "testmail20@t-mail.com");
