DROP TABLE IF EXISTS user_comments;
CREATE TABLE IF NOT EXISTS user_comments(
    commentID      INTEGER    PRIMARY KEY  AUTOINCREMENT,
    posterId       INTEGER    NOT_NULL,
    subjectId      INTEGER,
    description    TEXT,
    commentDate    TEXT,
    FOREIGN KEY (posterID) REFERENCES users(userID)
);
