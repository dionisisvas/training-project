DROP TABLE IF EXISTS hobbies;
CREATE TABLE IF NOT EXISTS hobbies(
	hobbyId		INTEGER   NOT_NULL,
	hobbyName  		TEXT      NOT_NULL UNIQUE,
	description	TEXT,
	PRIMARY KEY (hobbyId)
);

BEGIN TRANSACTION;
-- Skiing --
INSERT INTO hobbies(hobbyId, hobbyName, description)
VALUES (0, "Skiing", NULL);
-- Knitting --
INSERT INTO hobbies(hobbyId, hobbyName, description)
VALUES (1, "Knitting", NULL);
-- Chess --
INSERT INTO hobbies(hobbyId, hobbyName, description)
VALUES (2, "Chess", NULL);
-- Biking --
INSERT INTO hobbies(hobbyId, hobbyName, description)
VALUES (3, "Biking", NULL);
-- Travelling --
INSERT INTO hobbies(hobbyId, hobbyName, description)
VALUES (4, "Travelling", NULL);
-- Jogging --
INSERT INTO hobbies(hobbyId, hobbyName, description)
VALUES (5, "Jogging", NULL);
-- Martial Arts --
INSERT INTO hobbies(hobbyId, hobbyName, description)
VALUES (6, "Martial Arts", NULL);
-- Tennis --
INSERT INTO hobbies(hobbyId, hobbyName, description)
VALUES (7, "Tennis", NULL);
-- Football --
INSERT INTO hobbies(hobbyId, hobbyName, description)
VALUES (8, "Football", NULL);
-- Basketball --
INSERT INTO hobbies(hobbyId, hobbyName, description)
VALUES (9, "Basketball", NULL);
-- Cooking --
INSERT INTO hobbies(hobbyId, hobbyName, description)
VALUES (10, "Cooking", NULL);
-- Gardenning --
INSERT INTO hobbies(hobbyId, hobbyName, description)
VALUES (11, "Gardenning", NULL);
-- Gaming --
INSERT INTO hobbies(hobbyId, hobbyName, description)
VALUES (12, "Gaming", NULL);
-- Swimming --
INSERT INTO hobbies(hobbyId, hobbyName, description)
VALUES (13, "Swimming", NULL);
COMMIT;