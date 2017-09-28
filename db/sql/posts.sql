DROP TABLE IF EXISTS posts;
CREATE TABLE IF NOT EXISTS posts(
    id                INTEGER     PRIMARY KEY  AUTOINCREMENT,
    poster_id         INTEGER     NOT_NULL,
    subject_type      TEXT        NOT_NULL,
    subject_id        INTEGER     NOT_NULL,
    title             TEXT,    
    content           TEXT        NOT_NULL,
    creation_date     INTEGER     NOT_NULL,
    last_edit_date    INTEGER,
    FOREIGN KEY (poster_id) REFERENCES users(id)
);

INSERT INTO posts(id, poster_id, subject_type, subject_id, title, content, creation_date, last_edit_date) VALUES
(1, 1, "USER", 1, "Hello, world", "I'm so happy to be a member of this amazing service!", 1503142589, NULL),
(2, 1, "USER", 1, NULL, "Anybody from Athens?", 1503144689, NULL),
(3, 2, "USER", 1, "Hey!", "What game are you playing right now?", 1503148289, NULL),
(4, 1, "USER", 1, "Amazing game", "Had so much fun watching the game live last night", 1503223649, 1503224069),
(5, 3, "USER", 3, NULL, "Is this how you post?", 1503228509, NULL),
(6, 4, "USER", 4, NULL, "Hellooooooooooooo", 1503243869, NULL),
(7, 4, "USER", 7, NULL, "What's up? Long time no see", 1503254122, NULL),
(8, 6, "USER", 6, "Hey", "I'm new here!", 1503258660, NULL),
(9, 9, "USER", 10, "Follow this simple trick", "Work from home now and make over a bazillion dollars with this simple trick", 1503749733, NULL),
(10, 11, "USER", 11, NULL, "Where are all the memes?", 1504066544, 1504066644),
(11, 12, "USER", 12, NULL, "What's up guys?", 1504085529, NULL),
(12, 12, "USER", 12, NULL, "Anybody worth following?", 1504093749, NULL),
(13, 14, "USER", 9, "Yooo", "Wanna go downtown tonight?", 1504361473, NULL),
(14, 14, "USER", 2, NULL, "Call me when you get a chance. It's urgent.", 1504364876, 1504364936),
(15, 2, "USER", 14, NULL, "Missed your call, what's up?", 1504371662, NULL),
(16, 10, "USER", 15, "test post", "Nvm dude, this was a test post, just delete it. I can't find the button.", 1504632723, NULL),
(17, 17, "USER", 17, NULL, "Nervous for my interview tomorrow", 1505485168, NULL),
(18, 18, "USER", 18, NULL, "i LOVE daft punk", 1505705531, NULL),
(19, 15, "USER", 18, "Daft Punk are the best", "yooohoooo", 1506140705, NULL),
(20, 20, "USER", 20, "The economy is going down the drain", "Who's to blame?", 1506246120, 1506246472);
