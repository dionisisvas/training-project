DROP TABLE IF EXISTS user_hobbies;
CREATE TABLE IF NOT EXISTS user_hobbies(
    userId     INTEGER    NOT_NULL,
    hobbyId    INTEGER    NOT_NULL,
    FOREIGN KEY (userId) REFERENCES users(id)
);

INSERT INTO user_hobbies(userId, hobbyId) VALUES
-- User 1 --
(1, 1),  -- skiing
(1, 2),  -- knitting
-- User 2 --
(2, 3),  -- chess
-- User 3 --
(3, 4),  -- biking
(3, 5),  -- travelling
-- User 4 --
(4, 5),  -- travelling
(4, 2),  -- knitting
-- User 5 --
(5, 2),  -- knitting
-- User 6 --
(6, 6),  -- jogging
-- User 7 --
(7, 6),  -- jogging
(7, 7),  -- martial arts
(7, 8),  -- tennis
-- User 8 --
(8, 8),  -- tennis
-- User 9 --
(9, 2),  -- knitting
(9, 7),  -- martial arts
-- User 12 --
(12, 1),  -- skiing
-- User 13 --
(13, 9),  -- football
(13, 10),  -- basketball
-- User 14 --
(14, 11),  -- cooking
(14, 12),  -- gardenning
-- User 16 --
(16, 9),  -- football
-- User 17 --
(17, 13),  -- gaming
-- User 18 --
(18, 9),  -- football
-- User 19 --
(19, 4),  -- biking
-- User 20 --
(20, 13),  -- gaming
(20, 9),  -- football
(20, 14);  -- swimming
