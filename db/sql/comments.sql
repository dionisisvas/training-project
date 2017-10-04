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
(1, 1, "POST", 3, "Nothing, taking a break.", 1503248114, 1503248182),
(2, 8, "POST", 2, "Me!", 1503314534, NULL),
(3, 2, "POST", 8, "Welcome", 1503209002, 1503209182),
(4, 10, "POST", 9, "That is an amazing offer!", 1503831982, NULL),
(5, 11, "POST", 2, "Me too!", 1504100567, NULL),
(6, 1, "COMMENT", 5, "Hey! I know you!", 1504176261, NULL),
(7, 4, "POST", 17, "Relax, be yourself and good luck!", 1505497088, NULL),
(8, 6, "POST", 19, "Daft Punk? pffttt...", 1506165834, NULL),
(9, 6, "COMMENT",9, "I will find you, and I'll make you pay for those words!", 1506196598, NULL);
