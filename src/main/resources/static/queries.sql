

CREATE TABLE users (
    id int PRIMARY KEY,
    username VARCHAR(100),
    password VARCHAR(100),
    role VARCHAR(20)
);

CREATE TABLE events (
    id int  PRIMARY KEY,
    event_name VARCHAR(100),
    event_date DATE,
    location VARCHAR(100),
    details varchar(100)
);

CREATE TABLE registrations (
    id int PRIMARY KEY,
    user_id int,
    event_id int
);

INSERT INTO users(username,password,role)
VALUES ('admin','admin123','ADMIN');

INSERT INTO users(username,password,role)
VALUES ('user','user123','USER');