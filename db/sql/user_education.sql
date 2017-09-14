DROP TABLE IF EXISTS user_education;
CREATE TABLE IF NOT EXISTS user_education(
    user_id            INTEGER    NOT_NULL,
    school_name        TEXT       NOT_NULL,
    education_level    TEXT       NOT_NULL,
    graduated          INTEGER    NOT_NULL,
    start_year         INTEGER,
    end_year           INTEGER,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

INSERT INTO user_education(user_id, school_name, education_level, graduated, start_year, end_year) VALUES
-- User 1 --
(1, "7o ΓΕΛ Αθηνών", "SCHOOL", 1, 2011, 2014),
(1, "University of Leeds", "BACHELOR", 0, 2014, NULL),
-- User 2 --
(2, "University of Birmingham", "BACHELOR", 0, 2015, NULL),
-- User 5 --
(5, "TEI Αθηνών", "BACHELOR", 1, 2012, 2016),
(5, "TEI Αθηνών", "MASTER", 0, 2016, NULL),
-- User 12 --
(12, "2o EΠΑΛ Λαμίας", "SCHOOL", 1, 2007, 2012),
-- User 18 --
(18, "3o Γυμνάσιο Καλαμάτας", "SCHOOL", 1, 2003, 2006),
(18, "1o EΠΑΛ Καλαμάτας", "SCHOOL", 0, 2006, NULL);
