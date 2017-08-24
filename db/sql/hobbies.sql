DROP TABLE IF EXISTS hobbies;
CREATE TABLE IF NOT EXISTS hobbies(
    hobbyId        INTEGER    PRIMARY KEY  AUTOINCREMENT,
    hobbyName      TEXT       NOT_NULL  UNIQUE,
    description    TEXT
);

INSERT INTO hobbies(hobbyName, description) VALUES
-- Skiing --
("Skiing", NULL),
-- Knitting --
("Knitting", NULL),
-- Chess --
("Chess", NULL),
-- Biking --
("Biking", NULL),
-- Travelling --
("Travelling", NULL),
-- Jogging --
("Jogging", NULL),
-- Martial Arts --
("Martial Arts", NULL),
-- Tennis --
("Tennis", NULL),
-- Football --
("Football", NULL),
-- Basketball --
("Basketball", NULL),
-- Cooking --
("Cooking", NULL),
-- Gardenning --
("Gardenning", NULL),
-- Gaming --
("Gaming", NULL),
-- Swimming --
("Swimming", NULL);
