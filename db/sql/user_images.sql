DROP TABLE IF EXISTS user_images;
CREATE TABLE IF NOT EXISTS user_images(
	imgId  		 INTEGER   NOT_NULL, -- TODO: AUTO_INCREMENT doesn't work, check why.	
	userId  	 INTEGER   NOT_NULL,
	isProfileImg BOOLEAN   DEFAULT '0', 
	imgUri    	 TEXT	   NOT_NULL UNIQUE,
	PRIMARY KEY (imgId)
);

BEGIN TRANSACTION;
-- User 0 --
INSERT INTO user_images(imgId, userId, isProfileImg, imgUri)
VALUES (0, 0, 1, "resources/img/users/0_0.png");
INSERT INTO user_images(imgId, userId, isProfileImg, imgUri)
VALUES (1, 0, 0, "resources/img/users/0_1.png");
INSERT INTO user_images(imgId, userId, isProfileImg, imgUri)
VALUES (2, 0, 0, "resources/img/users/0_2.png");
-- User 2 --
INSERT INTO user_images(imgId, userId, isProfileImg, imgUri)
VALUES (3, 2, 1, "resources/img/users/2_0.png");
-- User 3 --
INSERT INTO user_images(imgId, userId, isProfileImg, imgUri)
VALUES (4, 3, 1, "resources/img/users/3_0.png");
-- User 4 --
INSERT INTO user_images(imgId, userId, isProfileImg, imgUri)
VALUES (5, 4, 1, "resources/img/users/4_0.png");
-- User 6 --
INSERT INTO user_images(imgId, userId, isProfileImg, imgUri)
VALUES (6, 6, 1, "resources/img/users/6_0.png");
INSERT INTO user_images(imgId, userId, isProfileImg, imgUri)
VALUES (7, 6, 0, "resources/img/users/6_1.png");
-- User 7 --
INSERT INTO user_images(imgId, userId, isProfileImg, imgUri)
VALUES (8, 7, 1, "resources/img/users/7_0.png");
-- User 8 --
INSERT INTO user_images(imgId, userId, isProfileImg, imgUri)
VALUES (9, 8, 1, "resources/img/users/8_0.png");
INSERT INTO user_images(imgId, userId, isProfileImg, imgUri)
VALUES (10, 8, 0, "resources/img/users/8_1.png");
-- User 9 --
INSERT INTO user_images(imgId, userId, isProfileImg, imgUri)
VALUES (11, 9, 1, "resources/img/users/9_0.png");
INSERT INTO user_images(imgId, userId, isProfileImg, imgUri)
VALUES (12, 9, 0, "resources/img/users/9_1.png");
-- User 11 --
INSERT INTO user_images(imgId, userId, isProfileImg, imgUri)
VALUES (13, 11, 1, "resources/img/users/11_0.png");
-- User 13 --
INSERT INTO user_images(imgId, userId, isProfileImg, imgUri)
VALUES (14, 13, 1, "resources/img/users/13_0.png");
INSERT INTO user_images(imgId, userId, isProfileImg, imgUri)
VALUES (15, 13, 0, "resources/img/users/13_1.png");
-- User 14 --
INSERT INTO user_images(imgId, userId, isProfileImg, imgUri)
VALUES (16, 14, 1, "resources/img/users/14_0.png");
-- User 17 --
INSERT INTO user_images(imgId, userId, isProfileImg, imgUri)
VALUES (17, 17, 1, "resources/img/users/17_0.png");
INSERT INTO user_images(imgId, userId, isProfileImg, imgUri)
VALUES (18, 17, 0, "resources/img/users/17_1.png");
-- User 19 --
INSERT INTO user_images(imgId, userId, isProfileImg, imgUri)
VALUES (19, 19, 1, "resources/img/users/19_0.png");
COMMIT;