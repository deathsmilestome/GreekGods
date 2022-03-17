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
phone INT,
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

