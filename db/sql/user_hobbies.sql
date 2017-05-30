DROP TABLE IF EXISTS user_hobbies;
CREATE TABLE IF NOT EXISTS user_hobbies(
	userId  	INTEGER	  NOT_NULL,	
	hobbyId 	INTEGER   NOT_NULL
);

BEGIN TRANSACTION;
-- User 0 --
INSERT INTO user_hobbies(userId, hobbyId)
VALUES (0, 0); -- skiing
INSERT INTO user_hobbies(userId, hobbyId)
VALUES (0, 1); -- knitting
-- User 1 --
INSERT INTO user_hobbies(userId, hobbyId)
VALUES (1, 2); -- chess
-- User 2 --
INSERT INTO user_hobbies(userId, hobbyId)
VALUES (2, 3); -- biking
INSERT INTO user_hobbies(userId, hobbyId)
VALUES (2, 4); -- travelling
-- User 3 --
INSERT INTO user_hobbies(userId, hobbyId)
VALUES (3, 4); -- travelling
INSERT INTO user_hobbies(userId, hobbyId)
VALUES (3, 1); -- knitting
-- User 4 --
INSERT INTO user_hobbies(userId, hobbyId)
VALUES (4, 1); -- knitting
-- User 5 --
INSERT INTO user_hobbies(userId, hobbyId)
VALUES (5, 5); -- jogging
-- User 6 --
INSERT INTO user_hobbies(userId, hobbyId)
VALUES (6, 5); -- jogging
INSERT INTO user_hobbies(userId, hobbyId)
VALUES (6, 6); -- martial arts
INSERT INTO user_hobbies(userId, hobbyId)
VALUES (6, 7); -- tennis
-- User 7 --
INSERT INTO user_hobbies(userId, hobbyId)
VALUES (7, 7); -- tennis
-- User 8 --
INSERT INTO user_hobbies(userId, hobbyId)
VALUES (8, 1); -- knitting
INSERT INTO user_hobbies(userId, hobbyId)
VALUES (8, 6); -- martial arts
-- User 11 --
INSERT INTO user_hobbies(userId, hobbyId)
VALUES (11, 0); -- skiing
-- User 12 --
INSERT INTO user_hobbies(userId, hobbyId)
VALUES (12, 8); -- football
INSERT INTO user_hobbies(userId, hobbyId)
VALUES (12, 9); -- basketball
-- User 13 --
INSERT INTO user_hobbies(userId, hobbyId)
VALUES (13, 10); -- cooking
INSERT INTO user_hobbies(userId, hobbyId)
VALUES (13, 11); -- gardenning
-- User 15 --
INSERT INTO user_hobbies(userId, hobbyId)
VALUES (15, 8); -- football
-- User 16 --
INSERT INTO user_hobbies(userId, hobbyId)
VALUES (16, 12); -- gaming
-- User 17 --
INSERT INTO user_hobbies(userId, hobbyId)
VALUES (17, 8); -- football
-- User 18 --
INSERT INTO user_hobbies(userId, hobbyId)
VALUES (18, 3); -- biking
-- User 19 --
INSERT INTO user_hobbies(userId, hobbyId)
VALUES (19, 12); -- gaming
INSERT INTO user_hobbies(userId, hobbyId)
VALUES (19, 8); -- football
INSERT INTO user_hobbies(userId, hobbyId)
VALUES (19, 13); -- swimming
COMMIT;