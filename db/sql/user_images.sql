DROP TABLE IF EXISTS user_images;
CREATE TABLE IF NOT EXISTS user_images(
    imgId           INTEGER     PRIMARY KEY AUTOINCREMENT,
    userId          INTEGER     NOT_NULL,
    isProfileImg    BOOLEAN     DEFAULT '0',
    imgUri          TEXT        NOT_NULL UNIQUE,
	FOREIGN KEY (userId) REFERENCES users(userId)
);

BEGIN TRANSACTION;
-- User 1 --
INSERT INTO user_images(userId, isProfileImg, imgUri)
VALUES (1, 1, "resources/img/users/1_0.png");
INSERT INTO user_images(userId, isProfileImg, imgUri)
VALUES (1, 0, "resources/img/users/1_1.png");
INSERT INTO user_images(userId, isProfileImg, imgUri)
VALUES (1, 0, "resources/img/users/1_2.png");
-- User 3 --
INSERT INTO user_images(userId, isProfileImg, imgUri)
VALUES (3, 1, "resources/img/users/3_0.png");
-- User 4 --
INSERT INTO user_images(userId, isProfileImg, imgUri)
VALUES (4, 1, "resources/img/users/4_0.png");
-- User 5 --
INSERT INTO user_images(userId, isProfileImg, imgUri)
VALUES (5, 1, "resources/img/users/5_0.png");
-- User 7 --
INSERT INTO user_images(userId, isProfileImg, imgUri)
VALUES (7, 1, "resources/img/users/7_0.png");
INSERT INTO user_images(userId, isProfileImg, imgUri)
VALUES (7, 0, "resources/img/users/7_1.png");
-- User 8 --
INSERT INTO user_images(userId, isProfileImg, imgUri)
VALUES (8, 1, "resources/img/users/8_0.png");
-- User 9 --
INSERT INTO user_images(userId, isProfileImg, imgUri)
VALUES (9, 1, "resources/img/users/9_0.png");
INSERT INTO user_images(userId, isProfileImg, imgUri)
VALUES (9, 0, "resources/img/users/9_1.png");
-- User 10 --
INSERT INTO user_images(userId, isProfileImg, imgUri)
VALUES (10, 1, "resources/img/users/10_0.png");
INSERT INTO user_images(userId, isProfileImg, imgUri)
VALUES (10, 0, "resources/img/users/10_1.png");
-- User 12 --
INSERT INTO user_images(userId, isProfileImg, imgUri)
VALUES (12, 1, "resources/img/users/12_0.png");
-- User 14 --
INSERT INTO user_images(userId, isProfileImg, imgUri)
VALUES (14, 1, "resources/img/users/14_0.png");
INSERT INTO user_images(userId, isProfileImg, imgUri)
VALUES (14, 0, "resources/img/users/14_1.png");
-- User 15 --
INSERT INTO user_images(userId, isProfileImg, imgUri)
VALUES (15, 1, "resources/img/users/15_0.png");
-- User 18 --
INSERT INTO user_images(userId, isProfileImg, imgUri)
VALUES (18, 1, "resources/img/users/18_0.png");
INSERT INTO user_images(userId, isProfileImg, imgUri)
VALUES (18, 0, "resources/img/users/18_1.png");
-- User 20 --
INSERT INTO user_images(userId, isProfileImg, imgUri)
VALUES (20, 1, "resources/img/users/20_0.png");
COMMIT;
