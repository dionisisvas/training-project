DROP TABLE IF EXISTS user_hobbies;
CREATE TABLE IF NOT EXISTS user_hobbies(
    userId      INTEGER   NOT_NULL,
    hobbyId     INTEGER   NOT_NULL
);

BEGIN TRANSACTION;
-- User 1 --
INSERT INTO user_hobbies(userId, hobbyId)
VALUES (1, 1); -- skiing
INSERT INTO user_hobbies(userId, hobbyId)
VALUES (1, 2); -- knitting
-- User 2 --
INSERT INTO user_hobbies(userId, hobbyId)
VALUES (2, 3); -- chess
-- User 3 --
INSERT INTO user_hobbies(userId, hobbyId)
VALUES (3, 4); -- biking
INSERT INTO user_hobbies(userId, hobbyId)
VALUES (3, 5); -- travelling
-- User 4 --
INSERT INTO user_hobbies(userId, hobbyId)
VALUES (4, 5); -- travelling
INSERT INTO user_hobbies(userId, hobbyId)
VALUES (4, 2); -- knitting
-- User 5 --
INSERT INTO user_hobbies(userId, hobbyId)
VALUES (5, 2); -- knitting
-- User 6 --
INSERT INTO user_hobbies(userId, hobbyId)
VALUES (6, 6); -- jogging
-- User 7 --
INSERT INTO user_hobbies(userId, hobbyId)
VALUES (7, 6); -- jogging
INSERT INTO user_hobbies(userId, hobbyId)
VALUES (7, 7); -- martial arts
INSERT INTO user_hobbies(userId, hobbyId)
VALUES (7, 8); -- tennis
-- User 8 --
INSERT INTO user_hobbies(userId, hobbyId)
VALUES (8, 8); -- tennis
-- User 9 --
INSERT INTO user_hobbies(userId, hobbyId)
VALUES (9, 2); -- knitting
INSERT INTO user_hobbies(userId, hobbyId)
VALUES (9, 7); -- martial arts
-- User 12 --
INSERT INTO user_hobbies(userId, hobbyId)
VALUES (12, 1); -- skiing
-- User 13 --
INSERT INTO user_hobbies(userId, hobbyId)
VALUES (13, 9); -- football
INSERT INTO user_hobbies(userId, hobbyId)
VALUES (13, 10); -- basketball
-- User 14 --
INSERT INTO user_hobbies(userId, hobbyId)
VALUES (14, 11); -- cooking
INSERT INTO user_hobbies(userId, hobbyId)
VALUES (14, 12); -- gardenning
-- User 16 --
INSERT INTO user_hobbies(userId, hobbyId)
VALUES (16, 9); -- football
-- User 17 --
INSERT INTO user_hobbies(userId, hobbyId)
VALUES (17, 13); -- gaming
-- User 18 --
INSERT INTO user_hobbies(userId, hobbyId)
VALUES (18, 9); -- football
-- User 19 --
INSERT INTO user_hobbies(userId, hobbyId)
VALUES (19, 4); -- biking
-- User 20 --
INSERT INTO user_hobbies(userId, hobbyId)
VALUES (20, 13); -- gaming
INSERT INTO user_hobbies(userId, hobbyId)
VALUES (20, 9); -- football
INSERT INTO user_hobbies(userId, hobbyId)
VALUES (20, 14); -- swimming
COMMIT;
