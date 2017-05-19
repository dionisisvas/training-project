DROP TABLE IF EXISTS hobbies;
CREATE TABLE IF NOT EXISTS hobbies(
	hobbyID	INTEGER   NOT_NULL,
	hobby  	TEXT      NOT_NULL UNIQUE,
	PRIMARY KEY (hobbyID)
);

BEGIN TRANSACTION;
-- Skiing --
INSERT INTO hobbies(hobbyID, hobby)
VALUES (0, "Skiing");
-- Knitting --
INSERT INTO hobbies(hobbyID, hobby)
VALUES (1, "Knitting");
-- Chess --
INSERT INTO hobbies(hobbyID, hobby)
VALUES (2, "Chess");
-- Biking --
INSERT INTO hobbies(hobbyID, hobby)
VALUES (3, "Biking");
-- Travelling --
INSERT INTO hobbies(hobbyID, hobby)
VALUES (4, "Travelling");
-- Jogging --
INSERT INTO hobbies(hobbyID, hobby)
VALUES (5, "Jogging");
-- Martial Arts --
INSERT INTO hobbies(hobbyID, hobby)
VALUES (6, "Martial Arts");
-- Tennis --
INSERT INTO hobbies(hobbyID, hobby)
VALUES (7, "Tennis");
-- Football --
INSERT INTO hobbies(hobbyID, hobby)
VALUES (8, "Football");
-- Basketball --
INSERT INTO hobbies(hobbyID, hobby)
VALUES (9, "Basketball");
-- Cooking --
INSERT INTO hobbies(hobbyID, hobby)
VALUES (10, "Cooking");
-- Gardenning --
INSERT INTO hobbies(hobbyID, hobby)
VALUES (11, "Gardenning");
-- Gaming --
INSERT INTO hobbies(hobbyID, hobby)
VALUES (12, "Gaming");
-- Swimming --
INSERT INTO hobbies(hobbyID, hobby)
VALUES (13, "Swimming");
COMMIT;