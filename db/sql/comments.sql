DROP TABLE IF EXISTS comments;
CREATE TABLE IF NOT EXISTS comments(
    id                INTEGER     PRIMARY KEY  AUTOINCREMENT,
    poster_id         INTEGER     NOT_NULL,
    subject_type      TEXT        NOT_NULL,
    subject_id        INTEGER     NOT_NULL,
    content           TEXT        NOT_NULL,
    creation_date     INTEGER     NOT_NULL,
    last_edit_date    INTEGER,
    FOREIGN KEY (poster_id) REFERENCES users(id)
);

INSERT INTO comments(id, poster_id, subject_type, subject_id, content, creation_date, last_edit_date) VALUES
(1, 7, "USER", 1, "John is the best guy ever :)", 1479249799, 1479249899),
(2, 1, "USER", 12, "Welcome to the network", 1479785641, NULL),
(3, 19, "USER", 17, "What game are you playing right now?", 1483339344, NULL),
(4, 14, "USER", 1, "Call me when you get a chance", 1491489341, 1491489441),
(5, 1, "USER", 14, "Missed your comment, what's up?", 149149942300, NULL),
(6, 5, "USER", 4, "Hellooooooooooooo", 1493434511, NULL),
(7, 14, "USER", 1, "What's up? Long time no see", 1501420766, NULL),
(8, 6, "USER", 3, "You owe me dude", 1502356755, NULL),
(9, 13, "USER", 8, "Work from home now and make over a bazillion dollars with this simple trick", 1504185566, NULL);
