DROP TABLE IF EXISTS user_images;
CREATE TABLE IF NOT EXISTS user_images(
	imgID  		 INTEGER   NOT_NULL, -- TODO: AUTO_INCREMENT doesn't work, check why.	
	userID  	 INTEGER   NOT_NULL,
	isProfileImg BOOLEAN   DEFAULT '0', 
	link    	 TEXT	   NOT_NULL,
	PRIMARY KEY (imgID)
);

BEGIN TRANSACTION;
-- User 0 --
INSERT INTO user_images(imgID, userID, isProfileImg, link)
VALUES (0, 0, 1, "resources/img/users/0_0.png");
INSERT INTO user_images(imgID, userID, isProfileImg, link)
VALUES (1, 0, 0, "resources/img/users/0_1.png");
INSERT INTO user_images(imgID, userID, isProfileImg, link)
VALUES (2, 0, 0, "resources/img/users/0_2.png");
-- User 2 --
INSERT INTO user_images(imgID, userID, isProfileImg, link)
VALUES (3, 2, 1, "resources/img/users/2_0.png");
-- User 3 --
INSERT INTO user_images(imgID, userID, isProfileImg, link)
VALUES (4, 3, 1, "resources/img/users/3_0.png");
-- User 4 --
INSERT INTO user_images(imgID, userID, isProfileImg, link)
VALUES (5, 4, 1, "resources/img/users/4_0.png");
-- User 6 --
INSERT INTO user_images(imgID, userID, isProfileImg, link)
VALUES (6, 6, 1, "resources/img/users/6_0.png");
INSERT INTO user_images(imgID, userID, isProfileImg, link)
VALUES (7, 6, 0, "resources/img/users/6_1.png");
-- User 7 --
INSERT INTO user_images(imgID, userID, isProfileImg, link)
VALUES (8, 7, 1, "resources/img/users/7_0.png");
-- User 8 --
INSERT INTO user_images(imgID, userID, isProfileImg, link)
VALUES (9, 8, 1, "resources/img/users/8_0.png");
INSERT INTO user_images(imgID, userID, isProfileImg, link)
VALUES (10, 8, 0, "resources/img/users/8_1.png");
-- User 9 --
INSERT INTO user_images(imgID, userID, isProfileImg, link)
VALUES (11, 9, 1, "resources/img/users/9_0.png");
INSERT INTO user_images(imgID, userID, isProfileImg, link)
VALUES (12, 9, 0, "resources/img/users/9_1.png");
-- User 11 --
INSERT INTO user_images(imgID, userID, isProfileImg, link)
VALUES (13, 11, 1, "resources/img/users/11_0.png");
-- User 13 --
INSERT INTO user_images(imgID, userID, isProfileImg, link)
VALUES (14, 13, 1, "resources/img/users/13_0.png");
INSERT INTO user_images(imgID, userID, isProfileImg, link)
VALUES (15, 13, 0, "resources/img/users/13_1.png");
-- User 14 --
INSERT INTO user_images(imgID, userID, isProfileImg, link)
VALUES (16, 14, 1, "resources/img/users/14_0.png");
-- User 17 --
INSERT INTO user_images(imgID, userID, isProfileImg, link)
VALUES (17, 17, 1, "resources/img/users/17_0.png");
INSERT INTO user_images(imgID, userID, isProfileImg, link)
VALUES (18, 17, 0, "resources/img/users/17_1.png");
-- User 19 --
INSERT INTO user_images(imgID, userID, isProfileImg, link)
VALUES (19, 19, 1, "resources/img/users/19_0.png");
COMMIT;