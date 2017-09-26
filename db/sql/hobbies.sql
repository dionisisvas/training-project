DROP TABLE IF EXISTS hobbies;
CREATE TABLE IF NOT EXISTS hobbies(
    id             INTEGER    PRIMARY KEY  AUTOINCREMENT,
    name           TEXT       NOT_NULL  UNIQUE,
    description    TEXT
);

INSERT INTO hobbies(name, description) VALUES
-- Hobby 1 --
("Skiing", NULL),
-- Hobby 2 --
("Knitting", NULL),
-- Hobby 3 --
("Chess", NULL),
-- Hobby 4 --
("Biking", NULL),
-- Hobby 5 --
("Travelling", NULL),
-- Hobby 6 --
("Jogging", NULL),
-- Hobby 7 --
("Martial Arts", NULL),
-- Hobby 8 --
("Tennis", NULL),
-- Hobby 9 --
("Football", NULL),
-- Hobby 10 --
("Basketball", NULL),
-- Hobby 11 --
("Cooking", NULL),
-- Hobby 12 --
("Gardenning", NULL),
-- Hobby 13 --
("Gaming", NULL),
-- Hobby 14 --
("Swimming", NULL),
-- Hobby 15 --
("Dancing", NULL),
-- Hobby 16 --
("Parkour", NULL),
-- Hobby 17 --
("Hiking", NULL),
-- Hobby 18 --
("Paintball", NULL),
-- Hobby 19 --
("Baseball", NULL),
-- Hobby 20 --
("Paragliding", NULL);
