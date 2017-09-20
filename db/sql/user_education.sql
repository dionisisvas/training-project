DROP TABLE IF EXISTS user_education;
CREATE TABLE IF NOT EXISTS user_education(
    user_id            INTEGER    NOT_NULL,
    school_name        TEXT       NOT_NULL,
    education_level    TEXT       NOT_NULL,
    graduated          INTEGER    DEFAULT '0',
    dropped_out        INTEGER    DEFAULT '0',
    start_year         INTEGER,
    end_year           INTEGER,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

INSERT INTO user_education(user_id, school_name, education_level, graduated, dropped_out, start_year, end_year) VALUES
-- User 1 --
(1, "7o ΓΕΛ Αθηνών", "SCHOOL", 1, 0, 2000, 2003),
(1, "University of Leeds", "BACHELOR", 0, 0, 2004, NULL),
-- User 2 --
(2, "University of Birmingham", "BACHELOR", 0, 0, 2010, NULL),
-- User 4 --
(4, "University of Texas at Austin", "BACHELOR", 1, 0, 1989, 1992),
-- User 7 --
(7, "Toronto High School", "SCHOOL", 1, 0, 1972, 1975),
(7, "Automative Training Centre", "TRADE_SCHOOL", 1, 0, 1976, 1977),
-- User 8 --
(8, "TEI Αθηνών", "BACHELOR", 1, 0, 2009, 2015),
(8, "TEI Αθηνών", "MASTER", 0, 0, 2016, NULL),
-- User 10 --
(10, "TEI Kαβάλας", "BACHELOR", 0, 1, 2011, NULL),
-- User 12 --
(12, "2o ΓΕΛ Αιγάλεω", "SCHOOL", 1, 0, 1994, 1997),
(12, "Πανεπιστήμιο Αθηνών", "BACHELOR", 1, 0, 1997, 2001),
(12, "Πανεπιστήμιο Αθηνών", "MASTER", 1, 0, 2001, 2003),
(12, "Πανεπιστήμιο Αθηνών", "DOCTORAL", 1, 0, 2003, 2008),
-- User 14 --
(14, "University of Bologna", "BACHELOR", 0, 0, 2013, NULL),
-- User 16 --
(16, "1o EΠΑΛ Βόλου", "SCHOOL", 1, 0, 1985, 1988),
-- User 17 --
(17, "Πανεπιστήμιο Ιωαννίνων", "BACHELOR", 0, 1, 2006, NULL),
-- User 18 --
(18, "University of Edinburgh", "BACHELOR", 0, 0, NULL, NULL),
-- User 20 --
(20, "Helene Lange Gymnasium", "SCHOOL", 1, 0, NULL, NULl);
