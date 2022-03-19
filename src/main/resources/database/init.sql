CREATE TABLE IF NOT EXISTS train_course
(
    id integer NOT NULL DEFAULT nextval('train_course_id_seq'::regclass),
    course_name character varying(30) COLLATE pg_catalog."default",
    CONSTRAINT train_course_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.eat_course
(
    id bigint NOT NULL DEFAULT nextval('eat_course_id_seq'::regclass),
    kilocalories integer,
    proteins integer,
    carbs integer,
    fats integer,
    water double precision,
    CONSTRAINT eat_course_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS user_info
(
    id bigint NOT NULL DEFAULT nextval('user_info_id_seq'::regclass),
    train_course_id integer NOT NULL DEFAULT 0,
    eat_course_id bigint NOT NULL DEFAULT 0,
    username character varying(50) COLLATE pg_catalog."default",
    pas character varying(30) COLLATE pg_catalog."default",
    first_name character varying(30) COLLATE pg_catalog."default",
    second_name character varying(30) COLLATE pg_catalog."default",
    phone bigint,
    weight double precision,
    CONSTRAINT user_info_pkey PRIMARY KEY (id),
    CONSTRAINT user_info_eat_course_id_key UNIQUE (eat_course_id),
    CONSTRAINT user_info_eat_course_id_fkey FOREIGN KEY (eat_course_id)
        REFERENCES public.eat_course (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT user_info_train_course_id_fkey FOREIGN KEY (train_course_id)
        REFERENCES public.train_course (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

CREATE TABLE IF NOT EXISTS train_day
(
    id integer NOT NULL DEFAULT nextval('train_day_id_seq'::regclass),
    train_day_name character varying(50) COLLATE pg_catalog."default",
    rest text COLLATE pg_catalog."default",
    CONSTRAINT train_day_pkey PRIMARY KEY (id)
);

create TABLE train_day_to_train_course
(
id_train_day INT REFERENCES train_day (id),
id_train_course INT REFERENCES train_course (id)
);

CREATE TABLE IF NOT EXISTS exercise
(
    id integer NOT NULL DEFAULT nextval('exercise_id_seq'::regclass),
    name character varying(30) COLLATE pg_catalog."default",
    sets character varying(10) COLLATE pg_catalog."default",
    reps character varying(10) COLLATE pg_catalog."default",
    weight character varying(15) COLLATE pg_catalog."default",
    description text COLLATE pg_catalog."default",
    CONSTRAINT exercise_pkey PRIMARY KEY (id)
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

