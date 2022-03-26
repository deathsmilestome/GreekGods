CREATE TABLE IF NOT EXISTS public.train_course
(
    id integer NOT NULL DEFAULT nextval('train_course_id_seq'::regclass),
    course_name character varying(30) COLLATE pg_catalog."default",
    CONSTRAINT train_course_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.train_course
    OWNER to postgres;

GRANT ALL ON TABLE public.train_course TO dstm;

GRANT ALL ON TABLE public.train_course TO postgres;


CREATE TABLE IF NOT EXISTS public.user_info
(
    id bigint NOT NULL DEFAULT nextval('user_info_id_seq'::regclass),
    train_course_id integer NOT NULL DEFAULT 1,
    username character varying(50) COLLATE pg_catalog."default",
    pas character varying(30) COLLATE pg_catalog."default",
    first_name character varying(30) COLLATE pg_catalog."default",
    second_name character varying(30) COLLATE pg_catalog."default",
    phone bigint,
    weight double precision,
    CONSTRAINT user_info_pkey PRIMARY KEY (id),
    CONSTRAINT user_info_train_course_id_fkey FOREIGN KEY (train_course_id)
        REFERENCES public.train_course (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.user_info
    OWNER to postgres;

GRANT ALL ON TABLE public.user_info TO dstm;

GRANT ALL ON TABLE public.user_info TO postgres;

CREATE TABLE IF NOT EXISTS public.train_day
(
    id integer NOT NULL DEFAULT nextval('train_day_id_seq'::regclass),
    train_day_name character varying(50) COLLATE pg_catalog."default",
    rest text COLLATE pg_catalog."default",
    CONSTRAINT train_day_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.train_day
    OWNER to postgres;

GRANT ALL ON TABLE public.train_day TO dstm;

GRANT ALL ON TABLE public.train_day TO postgres;

CREATE TABLE IF NOT EXISTS public.train_day_to_train_course
(
    id_train_day integer,
    id_train_course integer,
    CONSTRAINT train_day_to_train_course_id_train_course_fkey FOREIGN KEY (id_train_course)
        REFERENCES public.train_course (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT train_day_to_train_course_id_train_day_fkey FOREIGN KEY (id_train_day)
        REFERENCES public.train_day (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.train_day_to_train_course
    OWNER to postgres;

GRANT ALL ON TABLE public.train_day_to_train_course TO dstm;

GRANT ALL ON TABLE public.train_day_to_train_course TO postgres;

CREATE TABLE IF NOT EXISTS public.exercise
(
    id integer NOT NULL DEFAULT nextval('exercise_id_seq'::regclass),
    name character varying(30) COLLATE pg_catalog."default",
    sets character varying(10) COLLATE pg_catalog."default",
    reps character varying(10) COLLATE pg_catalog."default",
    weight character varying(15) COLLATE pg_catalog."default",
    description text COLLATE pg_catalog."default",
    CONSTRAINT exercise_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.exercise
    OWNER to postgres;

GRANT ALL ON TABLE public.exercise TO dstm;

GRANT ALL ON TABLE public.exercise TO postgres;

CREATE TABLE IF NOT EXISTS public.exercise_to_train_day
(
    id_exercise integer,
    id_train_day integer,
    CONSTRAINT exercise_to_train_day_id_exercise_fkey FOREIGN KEY (id_exercise)
        REFERENCES public.exercise (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT exercise_to_train_day_id_train_day_fkey FOREIGN KEY (id_train_day)
        REFERENCES public.train_day (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.exercise_to_train_day
    OWNER to postgres;

GRANT ALL ON TABLE public.exercise_to_train_day TO dstm;

GRANT ALL ON TABLE public.exercise_to_train_day TO postgres;

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

INSERT INTO user_info (train_course_id, username, pas, first_name, second_name, phone, weight)
VALUES (1, 'username1', 'pas1', 'firstname1', 'secondname2', 12345678999, 100.1),
(2, 'username2', 'pas2', 'firstname2', 'secondname2', 2345678999, 100.2),
(3, 'username3', 'pas3', 'firstname3', 'secondname3', 345678999, 100.3),
(4, 'username4', 'pas4', 'firstname4', 'secondname4', 45678999, 100.4),
(5, 'username5', 'pas5', 'firstname5', 'secondname5', 5678999, 100.5);

