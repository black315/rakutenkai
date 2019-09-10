DROP TABLE IF EXISTS USER_TEST;

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

--INSERT INTO USER (NAME, COUNTRY, USERNAME, CITY, GENDER, PICTURE_URL, RATING,  ROLE, BIRTHDATE, SELF_INTRODUCTION) VALUES
--  ('John Crom', 'Japan', 'john.crom', 'Osaka', 'Male', 'url', 3, 'USER', '2000/07/10', 'About John'),
--  ('Carla Pike', 'United States of America', 'carla.pike', 'Osaka', 'Female', 'url', 3, 'USER', '2000/07/10', 'About Carla'),
--  ('Thomas Fenmoy', 'Vietnam', 'thomas.fenmoy', 'Osaka', 'Male', 'url', 3, 'USER', '2000/07/10', 'About Thomas');