DROP TABLE IF EXISTS comment_replies;
CREATE TABLE IF NOT EXISTS comment_replies(
    id                INTEGER     PRIMARY KEY  AUTOINCREMENT,
    poster_id         INTEGER     NOT_NULL,
    parent_id         INTEGER     NOT_NULL,
    content           TEXT        NOT_NULL,
    creation_date     INTEGER     NOT_NULL,
    last_edit_date    INTEGER,
    FOREIGN KEY (parent_id) REFERENCES comments(id),
    FOREIGN KEY (poster_id) REFERENCES users(id)
);

INSERT INTO comment_replies(id, poster_id, parent_id, content, creation_date, last_edit_date) VALUES
(1, 1, 1, "Thank you for your kind words!", 1479250799, 1479250812),
(2, 19, 17, "Kerbal space program",  1483345350, NULL),
(3, 12, 2, "I'm having fun, thanks", 1483349312, NULL),
(4, 4, 6, "Yoooooooo", 1494222210, NULL),
(5, 8, 9, "Really? Tell me more", 1504185674, NULL);
