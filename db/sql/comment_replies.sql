DROP TABLE IF EXISTS comments;
CREATE TABLE IF NOT EXISTS comments(
    reply_id          INTEGER    PRIMARY KEY  AUTOINCREMENT,
    poster_id         INTEGER    NOT_NULL,
    parent_id         INTEGER    NOT_NULL,
    content           TEXT       NOT_NULL,
    creation_date     TEXT       NOT_NULL,
    last_edit_date    TEXT,
    FOREIGN KEY (parent_id) REFERENCES comments(comment_id),
    FOREIGN KEY (poster_id) REFERENCES users(userId)
);
