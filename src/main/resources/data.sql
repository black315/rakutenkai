
-- INSERT INTO lang(lang_id, lang_cap)
-- VALUES(1, 'Japanese'), (2, 'English'), (3, 'Italian'),
-- (4, 'French'), (5, 'Chinese'), (6, 'Korean'),
-- (7, 'Spanish'), (8, 'Hindi'), (9, 'Malay'),
-- (10, 'Russian'), (11, 'Portuguese');
DROP TABLE IF EXISTS lang;
CREATE TABLE IF NOT EXISTS lang(
  lang_id INT(10) PRIMARY KEY AUTO_INCREMENT,
  lang_cap VARCHAR(100)
);
INSERT INTO USER (NAME, COUNTRY, USERNAME, CITY, GENDER, PICTURE_URL, RATING,  ROLE, BIRTHDATE, SELF_INTRODUCTION, LATITUDE, LONGITUDE, PASSWORD) VALUES

('John Crom', 'Japan', 'john.crom', 'Osaka', 'Male', 'url', 3, 'USER', '2000/07/10', 'About John', 34.703715, 135.494137, '$2a$10$BB1J66T/3kMcmidDah0R7OJtycBKlvJObNsW0DuSHYOoXmsVTt3bK'),
('Carla Pike', 'United States of America', 'carla.pike', 'Osaka', 'Female', 'url', 3, 'USER', '2000/07/10', 'About Carla', 34.703582, 135.496104,'$2a$10$BB1J66T/3kMcmidDah0R7OJtycBKlvJObNsW0DuSHYOoXmsVTt3bK'),
('Thomas Fenmoy', 'Vietnam', 'thomas.fenmoy', 'Osaka', 'Male', 'url', 3, 'USER', '2000/07/10', 'About Thomas', 34.702171, 135.497381,'$2a$10$BB1J66T/3kMcmidDah0R7OJtycBKlvJObNsW0DuSHYOoXmsVTt3bK'),
('Doraemon', 'Japan', 'anpan.man', 'Tokyo', 'Male', 'url', 3, 'USER', '2000/07/10', 'About Doraemon', 35.681876, 139.769252,'$2a$10$BB1J66T/3kMcmidDah0R7OJtycBKlvJObNsW0DuSHYOoXmsVTt3bK'),
('Gopher', 'Japan', 'go.lang', 'Tokyo', 'Male', 'url', 3, 'USER', '2000/07/10', 'About Gopher', 35.679580, 139.764515,'$2a$10$BB1J66T/3kMcmidDah0R7OJtycBKlvJObNsW0DuSHYOoXmsVTt3bK'),
('Carl Times', 'Japan', 'carl.times', 'Nagoya', 'Male', 'url', 3, 'USER', '1998/07/10', 'Likes Languages and music', 35.170519, 136.880218,'$2a$10$BB1J66T/3kMcmidDah0R7OJtycBKlvJObNsW0DuSHYOoXmsVTt3bK');

INSERT INTO TAG (NAME) VALUES
('Medical support'),
('Transportation'),
('Pension'),
('National Insurrance'),
('Translation'),
('Accomodation'),
('Ward office'),
('Immigration'),
('Moving'),
('Tourism'),
('Restaurants'),
('Religion'),
('Japanese Traditional Arts'),
('Real Estate');

INSERT INTO USER_TAGS (USER_ID, TAGS_TAG_ID) VALUES
    (1, 1),
    (1, 2),
    (1, 3),
    (2, 1),
    (2, 3),
    (3, 1),
    (3, 4),
    (4, 2),
    (4, 6),
    (4, 7),
    (5, 4),
    (5, 7),
    (5, 9),
    (6, 1),
    (6, 2),
    (6, 8);



