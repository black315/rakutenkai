
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

('John Crom', 'Japan', 'john.crom', 'Osaka', 'Male', 'url', 3, 'USER', '2000/07/10', 'About John', 34.703715, 135.494137, '1234'),
('Carla Pike', 'United States of America', 'carla.pike', 'Osaka', 'Female', 'url', 3, 'USER', '2000/07/10', 'About Carla', 34.703582, 135.496104,'1234'),
('Thomas Fenmoy', 'Vietnam', 'thomas.fenmoy', 'Osaka', 'Male', 'url', 3, 'USER', '2000/07/10', 'About Thomas', 34.702171, 135.497381,'1234'),
('Doraemon', 'Japan', 'anpan.man', 'Tokyo', 'Male', 'url', 3, 'USER', '2000/07/10', 'About Doraemon', 35.681876, 139.769252,'1234'),
('Gopher', 'Japan', 'go.lang', 'Tokyo', 'Male', 'url', 3, 'USER', '2000/07/10', 'About Gopher', 35.679580, 139.764515,'1234'),
('Carl Times', 'Japan', 'carl.times', 'Nagoya', 'Male', 'url', 3, 'USER', '1998/07/10', 'Likes Languages and music', 35.170519, 136.880218,'1234');

INSERT INTO TAG (NAME) VALUES
('Medical support'),
('Transportation'),
('Pension'),
('National Insurance'),
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

INSERT INTO APPOINTMENT (REQUESTER_ID, REQUESTED_ID, DATE, CITY, PLACE, DETAILS, TAG_TAG_ID) VALUES
(1, 4, '2019/10/02', 'Osaka', 'Umeda station' , 'Please help me with some paperwork at the post office!', 5),
(2, 3, '2019/07/04', 'Tokyo', 'Tokyo station' , 'Does anyone have which clinic has doctor who speaks English?', 1),
(2, 4, '2019/09/01', 'Tokyo', 'Shibuya station' , 'How can I get to Disney sea by bus?', 2),
(1, 3, '2019/05/02', 'Hyogo', 'Akashi station' , 'Do I have to pay pension if I am a student?', 3),
(3, 4, '2019/06/04', 'Hokkaido', 'Sapporo station' , 'Why do I need to pay insurance?', 4),
(4, 5, '2018/10/02', 'Kyoto', 'Kawaramachi station' , 'Is ABC hotel really near to station?', 6),
(1, 5, '2019/10/10', 'Toyama', 'Kanazawa station' , 'How can I get to Raichosawa camping site from toyama kanazawa station?', 10);

INSERT INTO MESSAGE (USER_ID, USER_TO_ID, CONTENT, TIMESTAMP, PRIVATE_MESSAGE) VALUES
 (1, 2, 'Hello', '2019-09-12 10:03:46', false),
 (2, 1, 'Hi', '2019-09-12 10:05:27', false),
 (1, 2, 'How are you?', '2019-09-12 10:05:30', false),
 (3, 1, 'Good morning', '2019-09-12 10:07:00', false),
 (1, 2, 'Please help me!!', '2019-09-12 10:08:17', false);

