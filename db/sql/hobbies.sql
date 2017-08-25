DROP TABLE IF EXISTS hobbies;
CREATE TABLE IF NOT EXISTS hobbies(
    hobbyId         INTEGER     PRIMARY KEY AUTOINCREMENT,
    hobbyName       TEXT        NOT_NULL UNIQUE,
    description     TEXT
);

BEGIN TRANSACTION;
-- Skiing --
INSERT INTO hobbies(hobbyName, description)
VALUES ("Skiing", NULL);
-- Knitting --
INSERT INTO hobbies(hobbyName, description)
VALUES ("Knitting", NULL);
-- Chess --
INSERT INTO hobbies(hobbyName, description)
VALUES ("Chess", NULL);
-- Biking --
INSERT INTO hobbies(hobbyName, description)
VALUES ("Biking", NULL);
-- Travelling --
INSERT INTO hobbies(hobbyName, description)
VALUES ("Travelling", NULL);
-- Jogging --
INSERT INTO hobbies(hobbyName, description)
VALUES ("Jogging", NULL);
-- Martial Arts --
INSERT INTO hobbies(hobbyName, description)
VALUES ("Martial Arts", NULL);
-- Tennis --
INSERT INTO hobbies(hobbyName, description)
VALUES ("Tennis", NULL);
-- Football --
INSERT INTO hobbies(hobbyName, description)
VALUES ("Football", NULL);
-- Basketball --
INSERT INTO hobbies(hobbyName, description)
VALUES ("Basketball", NULL);
-- Cooking --
INSERT INTO hobbies(hobbyName, description)
VALUES ("Cooking", NULL);
-- Gardenning --
INSERT INTO hobbies(hobbyName, description)
VALUES ("Gardenning", NULL);
-- Gaming --
INSERT INTO hobbies(hobbyName, description)
VALUES ("Gaming", NULL);
-- Swimming --
INSERT INTO hobbies(hobbyName, description)
VALUES ("Swimming", NULL);
COMMIT;
