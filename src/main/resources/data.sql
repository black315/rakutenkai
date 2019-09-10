
-- INSERT INTO gender(gender_id, gender_cap)
-- VALUES(1, 'men'), (2, 'women'), (3, 'other');

-- INSERT INTO lang(lang_id, lang_cap) 
-- VALUES(1, 'Japanese'), (2, 'English'), (3, 'Italian'), 
-- (4, 'French'), (5, 'Chinese'), (6, 'Korean'), 
-- (7, 'Spanish'), (8, 'Hindi'), (9, 'Malay'), 
-- (10, 'Russian'), (11, 'Portuguese');

DROP TABLE IF EXISTS USER_TEST;
DROP TABLE IF EXISTS gender;
DROP TABLE IF EXISTS lang;

CREATE TABLE IF NOT EXISTS gender(
    gender_id INT(10) PRIMARY KEY AUTO_INCREMENT,
    gender_cap VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS lang(
    lang_id INT(10) PRIMARY KEY AUTO_INCREMENT,
    lang_cap VARCHAR(100)
);

CREATE TABLE USER_TEST (
  ID INT AUTO_INCREMENT PRIMARY KEY,
  NAME VARCHAR(250) NOT NULL,
  COUNTRY VARCHAR(40) NOT NULL,
  USERNAME VARCHAR(20) NOT NULL,
  PASSWORD VARCHAR(800) NOT NULL,
  ROLE VARCHAR(20) NOT NULL,
);

INSERT INTO USER_TEST (NAME, COUNTRY, USERNAME, PASSWORD, ROLE) VALUES
  ('John Crom', 'Japan', 'john.crom', '$2a$10$BB1J66T/3kMcmidDah0R7OJtycBKlvJObNsW0DuSHYOoXmsVTt3bK', 'USER'),
  ('Carla Pike', 'United States of America', 'carla.pike', '$2a$10$BB1J66T/3kMcmidDah0R7OJtycBKlvJObNsW0DuSHYOoXmsVTt3bK', 'USER'),
  ('Thomas Fenmoy', 'Vietnam', 'thomas.fenmoy', '$2a$10$BB1J66T/3kMcmidDah0R7OJtycBKlvJObNsW0DuSHYOoXmsVTt3bK', 'USER');

INSERT INTO USER (NAME, COUNTRY, USERNAME, CITY, GENDER, PICTURE_URL, RATING,  ROLE, BIRTHDATE, SELF_INTRODUCTION) VALUES
  ('John Crom', 'Japan', 'john.crom', 'Osaka', 'Male', 'url', 3, 'USER', '2000/07/10', 'About John'),
  ('Carla Pike', 'United States of America', 'carla.pike', 'Osaka', 'Female', 'url', 3, 'USER', '2000/07/10', 'About Carla'),
  ('Thomas Fenmoy', 'Vietnam', 'thomas.fenmoy', 'Osaka', 'Male', 'url', 3, 'USER', '2000/07/10', 'About Thomas'),
  ('Doraemon', 'Japan', 'anpan.man', 'Tokyo', 'Male', 'url', 3, 'USER', '2000/07/10', 'About Doraemon'),
  ('Gopher', 'USA', 'go.lang', 'LA', 'Male', 'url', 3, 'USER', '2000/07/10', 'About Gopher');
