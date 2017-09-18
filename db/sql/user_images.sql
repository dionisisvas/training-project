DROP TABLE IF EXISTS user_images;
CREATE TABLE IF NOT EXISTS user_images(
    imgId           INTEGER    PRIMARY KEY  AUTOINCREMENT,
    userId          INTEGER    NOT_NULL,
    isProfileImg    BOOLEAN    DEFAULT '0',
    imgUri          TEXT       NOT_NULL  UNIQUE,
    FOREIGN KEY (userId) REFERENCES users(id)
);

INSERT INTO user_images(userId, isProfileImg, imgUri) VALUES
-- User 1 --
(1, 1, "resources/img/users/1_0.png"),
(1, 0, "resources/img/users/1_1.png"),
(1, 0, "resources/img/users/1_2.png"),
-- User 3 --
(3, 1, "resources/img/users/3_0.png"),
-- User 4 --
(4, 1, "resources/img/users/4_0.png"),
-- User 5 --
(5, 1, "resources/img/users/5_0.png"),
-- User 7 --
(7, 1, "resources/img/users/7_0.png"),
(7, 0, "resources/img/users/7_1.png"),
-- User 8 --
(8, 1, "resources/img/users/8_0.png"),
-- User 9 --
(9, 1, "resources/img/users/9_0.png"),
(9, 0, "resources/img/users/9_1.png"),
-- User 10 --
(10, 1, "resources/img/users/10_0.png"),
(10, 0, "resources/img/users/10_1.png"),
-- User 12 --
(12, 1, "resources/img/users/12_0.png"),
-- User 14 --
(14, 1, "resources/img/users/14_0.png"),
(14, 0, "resources/img/users/14_1.png"),
-- User 15 --
(15, 1, "resources/img/users/15_0.png"),
-- User 18 --
(18, 1, "resources/img/users/18_0.png"),
(18, 0, "resources/img/users/18_1.png"),
-- User 20 --
(20, 1, "resources/img/users/20_0.png");
