create TABLE train_course
(
id INT PRIMARY KEY,
course_name VARCHAR(30)
);

create TABLE eat_course
(
id INT PRIMARY KEY,
kilocalories INT,
proteins INT,
carbs INT,
fats INT,
water FLOAT
);

create TABLE user_info
(
id INT PRIMARY KEY,
train_course_id INT NOT NULL unique REFERENCES  train_course (id),
eat_course_id INT NOT NULL REFERENCES  eat_course (id),
username VARCHAR(50),
pas VARCHAR(30),
first_name VARCHAR(30),
second_name VARCHAR(30),
phone BIGINT,
weight FLOAT
);

create TABLE train_day
(
id INT PRIMARY KEY,
train_day_name VARCHAR(50),
rest TEXT
);

create TABLE train_day_to_train_course
(
id_train_day INT REFERENCES train_day (id),
id_train_course INT REFERENCES train_course (id)
);

create TABLE exercise
(
id INT PRIMARY KEY,
"name" VARCHAR(30),
sets VARCHAR(10),
reps VARCHAR(10),
weight VARCHAR(15),
description TEXT
);

create TABLE exercise_to_train_day
(
id_exercise INT REFERENCES exercise (id),
id_train_day INT REFERENCES train_day (id)
);

INSERT INTO exercise (name, sets, reps, weight, description)
VALUES ('test name1', '1-2', '11', '10 kg', 'go hard1'),
('test name2', '2-3', '12', '20 kg', 'go hard2'),
('test name3', '3-4', '13', '30 kg', 'go hard3'),
('test name4', '4-5', '14', '40 kg', 'go hard4'),
('test name5', '5', '15', '50 kg', 'go hard5');

INSERT INTO train_day (train_day_name, rest)
VALUES ('train_day_name1', 'rest1'),
('train_day_name2', 'rest2'),
('train_day_name3', 'rest3'),
('train_day_name4', 'rest4'),
('train_day_name5', 'rest5');

INSERT INTO train_course (course_name)
VALUES ('course_name1'),
('course_name2'),
('course_name3'),
('course_name4'),
('course_name5');

INSERT INTO eat_course (kilocalories, proteins, carbs, fats, water)
VALUES (1000, 100, 110, 10, 1.1),
(2000, 200, 210, 20, 2.1),
(3000, 300, 310, 30, 3.1),
(4000, 400, 410, 40, 4.1),
(5000, 500, 510, 50, 5.1);

INSERT INTO exercise_to_train_day (id_exercise, id_train_day)
VALUES (1, 1),
(1, 2),
(2, 1),
(2, 2),
(3, 1),
(3, 2),
(4, 3),
(4, 4),
(5, 4),
(5, 5);

INSERT INTO train_day_to_train_course (id_train_day, id_train_course)
VALUES (1, 1),
(1, 2),
(2, 1),
(2, 2),
(3, 1),
(3, 2),
(4, 3),
(4, 4),
(5, 4),
(5, 5);

INSERT INTO user_info (train_course_id, eat_course_id, username, pas, first_name, second_name, phone, weight)
VALUES (1, 1, 'username1', 'pas1', 'firstname1', 'secondname2', 12345678999, 100.1),
(2, 2, 'username2', 'pas2', 'firstname2', 'secondname2', 2345678999, 100.2),
(3, 3, 'username3', 'pas3', 'firstname3', 'secondname3', 345678999, 100.3),
(4, 4, 'username4', 'pas4', 'firstname4', 'secondname4', 45678999, 100.4),
(5, 5, 'username5', 'pas5', 'firstname5', 'secondname5', 5678999, 100.5);
