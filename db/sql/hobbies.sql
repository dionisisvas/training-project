DROP TABLE IF EXISTS hobbies;
CREATE TABLE IF NOT EXISTS hobbies(
	hobbyId	INTEGER   NOT_NULL,
	hobby  	TEXT      NOT_NULL UNIQUE,
	PRIMARY KEY (hobbyId)
);

BEGIN TRANSACTION;
-- Skiing --
INSERT INTO hobbies(hobbyId, hobby)
VALUES (0, "Skiing");
-- Knitting --
INSERT INTO hobbies(hobbyId, hobby)
VALUES (1, "Knitting");
-- Chess --
INSERT INTO hobbies(hobbyId, hobby)
VALUES (2, "Chess");
-- Biking --
INSERT INTO hobbies(hobbyId, hobby)
VALUES (3, "Biking");
-- Travelling --
INSERT INTO hobbies(hobbyId, hobby)
VALUES (4, "Travelling");
-- Jogging --
INSERT INTO hobbies(hobbyId, hobby)
VALUES (5, "Jogging");
-- Martial Arts --
INSERT INTO hobbies(hobbyId, hobby)
VALUES (6, "Martial Arts");
-- Tennis --
INSERT INTO hobbies(hobbyId, hobby)
VALUES (7, "Tennis");
-- Football --
INSERT INTO hobbies(hobbyId, hobby)
VALUES (8, "Football");
-- Basketball --
INSERT INTO hobbies(hobbyId, hobby)
VALUES (9, "Basketball");
-- Cooking --
INSERT INTO hobbies(hobbyId, hobby)
VALUES (10, "Cooking");
-- Gardenning --
INSERT INTO hobbies(hobbyId, hobby)
VALUES (11, "Gardenning");
-- Gaming --
INSERT INTO hobbies(hobbyId, hobby)
VALUES (12, "Gaming");
-- Swimming --
INSERT INTO hobbies(hobbyId, hobby)
VALUES (13, "Swimming");
COMMIT;