DROP TABLE IF EXISTS USER_SELECTED_DATES;
CREATE TABLE IF NOT EXISTS USER_SELECTED_DATES(
    eventId         INTEGER    PRIMARY KEY  AUTOINCREMENT,
    userId          INTEGER    NOT_NULL,
    dateOfEvent     TEXT,
    Title           TEXT,
    Description     TEXT,
    FOREIGN KEY (userId) REFERENCES users(userId)
);

INSERT INTO USER_SELECTED_DATES(userId, dateOfEvent, Title, Description) VALUES
-- User 1 selected dates --
(1, "1940-06-12", "Graduation","Graduated from university"),
(1, "1945-06-12", "Marriage","I married to Sonia"),
(1, "1950-02-02", "Father","My first child was born"),
-- User 2 selected dates --
(2, "2014-02-08", "Graduation","Graduated from high school"),
-- User 3 selected dates --
(3, "2004-07-08", "Training","Started Chef courses"),
(3, "2007-07-08", "Work","Started working as a Chef"),
-- User 4 selected dates --
(4, "2009-07-08", "Training","Started karate lessons"),
-- User 5 selected dates --
(5, "2009-09-28", "Friend","I became friend with Json"),
-- User 6 selected dates --
(6, "1990-06-12", "Graduation","I got my master's degree in the University of ST.Thomas"),
(6, "1996-09-18", "Marriage","I married to Lenna"),
-- User 7 selected dates --
(7, "1985-03-18", "Marriage","I married to John"),
(7, "1988-03-18", "Mother","Birth of my child"),
-- User 8 selected dates --
(8, "2089-02-08", "Graduation","Graduated from high school"),
-- User 9 selected dates --
(9, "2016-03-18", "Marriage","I married to Sofia"),
-- User 10 selected dates --
(10, "2017-03-18", "Graduation","Graduated from university"),
-- User 11 selected dates --
(11, "1983-03-18", "Marriage","I married to Maria"),
-- User 13 selected dates --
(13, "2010-05-24", "Work","Started working as a mechanic");