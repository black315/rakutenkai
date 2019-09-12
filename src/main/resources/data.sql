
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

INSERT INTO USER (NAME, COUNTRY, USERNAME, CITY, GENDER, PICTURE_URL, RATING,  ROLE, BIRTHDATE, SELF_INTRODUCTION, LATITUDE, LONGITUDE) VALUES
  ('John Crom', 'Japan', 'john.crom', 'Osaka', 'Male', 'url', 3, 'USER', '2000/07/10', 'About John', 34.41, 135.3),
  ('Carla Pike', 'United States of America', 'carla.pike', 'Osaka', 'Female', 'url', 3, 'USER', '2000/07/10', 'About Carla', 34.411, 135.301),
  ('Thomas Fenmoy', 'Vietnam', 'thomas.fenmoy', 'Osaka', 'Male', 'url', 3, 'USER', '2000/07/10', 'About Thomas', 34.412, 135.302),
  ('Doraemon', 'Japan', 'anpan.man', 'Tokyo', 'Male', 'url', 3, 'USER', '2000/07/10', 'About Doraemon', 35.66372, 139.73100),
  ('Gopher', 'USA', 'go.lang', 'LA', 'Male', 'url', 3, 'USER', '2000/07/10', 'About Gopher', 35.66772, 139.73100);

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
    (2, 2);


