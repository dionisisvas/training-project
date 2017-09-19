DROP TABLE IF EXISTS accounts;
CREATE TABLE IF NOT EXISTS accounts(
    id           INTEGER    PRIMARY KEY,
    username     TEXT       NOT_NULL  UNIQUE  COLLATE NOCASE,
    password     TEXT       NOT_NULL,
    email        TEXT       NOT_NULL  UNIQUE  COLLATE NOCASE,
    join_date    INTEGER    NOT_NULL,
    FOREIGN KEY (id) REFERENCES users(id)
);

INSERT INTO accounts(id, username, password, email, join_date) VALUES
-- User 1 --
(1, "jpap",  "password1", "john.pappas@t-mail.com", 1503141306),
-- User 2 --
(2, "jane2",  "password2", "jslater@t-mail.com", 1503144663),
-- User 3 --
(3, "chris_g",  "password3", "cgian@t-mail.com", 1503165780),
-- User 4 --
(4, "JSON",  "password4", "jason.brown@t-mail.com", 1503165786),
-- User 5 --
(5, "x_Zoe_x",  "password5", "zoe.an@t-mail.com", 1503166086),
-- User 6 --
(6, "jimd",  "password6", "darulo.jim@t-mail.com", 1503183272),
-- User 7 --
(7, "mairy_",  "password7", "abraham.mairy@t-mail.com", 1503211496),
-- User 8 --
(8, "pantelinio",  "password8", "jpantelis@t-mail.com", 1503231934),
-- User 9 --
(9, "giorgio_g7",  "password9", "mancini.george@t-mail.com", 1503588874),
-- User 10 --
(10, "dim",  "password10", "dimitrakakis@t-mail.com", 1503749541),
-- User 11 --
(11, "athan61",  "password11", "athanasiou61@t-mail.com", 1504036621),
-- User 12 --
(12, "jenny",  "password12", "jennaki@t-mail.com", 1504037042),
-- User 13 --
(13, "DonL",  "password13", "don.lewis@t-mail.com", 1504147652),
-- User 14 --
(14, "the_romero",  "password14", "bromero@t-mail.com", 1504254683),
-- User 15 --
(15, "heather1",  "password15", "h.paxton@t-mail.com", 1504617737),
-- User 16 --
(16, "john123",  "password16", "papadopoulos.j@t-mail.com", 1504951439),
-- User 17 --
(17, "dg88",  "password17", "dimitra88@t-mail.com", 1505412420),
-- User 18 --
(18, "trulli_not_jarno",  "password18", "andrew.trulli@t-mail.com", 1505652983),
-- User 19 --
(19, "nigel91",  "password19", "n.smith@t-mail.com", 1505692528),
-- User 20 --
(20, "fischer84",  "password20", "w.fischer.84@t-mail.com", 1505819888);
