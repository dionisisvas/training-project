DROP TABLE IF EXISTS comments;
CREATE TABLE IF NOT EXISTS comments(
    comment_id        INTEGER    PRIMARY KEY  AUTOINCREMENT,
    poster_id         INTEGER    NOT_NULL,
    subject_type      INTEGER    NOT_NULL,
    subject_id        INTEGER    NOT_NULL,
    title             TEXT       NOT_NULL,
    body              TEXT       NOT_NULL,
    creation_date     TEXT       NOT_NULL,
    last_edit_date    TEXT,
    FOREIGN KEY (poster_id) REFERENCES users(userId)
);
