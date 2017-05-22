DROP TABLE IF EXISTS USER_COMMENT;
CREATE TABLE IF NOT EXISTS USER_COMMENT(
	commID 	  	 INTEGER,
	descrip      TEXT,
	comdate    	 datetime,
	userID  	 INTEGER, 
	FOREIGN KEY (userID) REFERENCES USERS(userID)
);

BEGIN TRANSACTION;

INSERT INTO USER_COMMENT(commID, descrip, comdate, userID)
VALUES ( 0, "John", "2017-08-24 12:45:12", 0);

INSERT INTO USER_COMMENT(commID, descrip, comdate, userID)
VALUES ( 1, "Jane", "2016-03-24 17:45:12"0);

INSERT INTO USER_COMMENT(commID, descrip, comdate, userID)
VALUES ( 2, "Chris", "2017-04-24 18:45:12", 1);

INSERT INTO USER_COMMENT(commID, descrip, comdate, userID)
VALUES ( 3, "Jason", "2017-03-24 17:45:12", 3);

INSERT INTO USER_COMMENT(commID, descrip, comdate, userID)
VALUES ( 4, "Doe", "2015-03-24 17:45:12", 3);

INSERT INTO USER_COMMENT(commID, descrip, comdate, userID)
VALUES ( 5, "Jim", "2017-07-23 11:45:12", 10);

INSERT INTO USER_COMMENT(commID, descrip, comdate, userID)
VALUES ( 6, "Jane", "2014-01-24 13:45:12", 10);

INSERT INTO USER_COMMENT(commID, descrip, comdate, userID)
VALUES ( 7, "John", "2012-03-24 14:45:12", 11);

INSERT INTO USER_COMMENT(commID, descrip, comdate, userID)
VALUES ( 8, "Jason", "2015-03-24 17:45:12", 11);

INSERT INTO USER_COMMENT(commID, descrip, comdate, userID)
VALUES ( 9, "Doe", "2017-03-24 15:45:12", 11);

INSERT INTO USER_COMMENT(commID, descrip, comdate, userID)
VALUES ( 10, "John", "2014-03-24 17:23:12", 12);

INSERT INTO USER_COMMENT(commID, descrip, comdate, userID)
VALUES ( 11, "Jane", "2017-03-24 17:45:12", 12);

INSERT INTO USER_COMMENT(commID, descrip, comdate, userID)
VALUES ( 12, "Don", "2017-05-21 17:00:12", 13);

INSERT INTO USER_COMMENT(commID, descrip, comdate, userID)
VALUES ( 13, "Jason", "2017-03-24 17:45:12", 13);

INSERT INTO USER_COMMENT(commID, descrip, comdate, userID)
VALUES ( 14, "Doe", "2017-03-24 17:45:12",15);

INSERT INTO USER_COMMENT(commID, descrip, comdate, userID)
VALUES ( 15, "John", "2017-03-24 17:45:12",15);

INSERT INTO USER_COMMENT(commID, descrip, comdate, userID)
VALUES ( 16, "Jane", "2017-03-24 17:45:12",17);

INSERT INTO USER_COMMENT(commID, descrip, comdate, userID)
VALUES (17, "Chris", "2017-05-21 17:45:12",18);

COMMIT;