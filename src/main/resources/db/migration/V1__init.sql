CREATE TABLE PERSON
(
    id NUMBER PRIMARY KEY,
    name VARCHAR2(50) NOT NULL,
    birthdate TIMESTAMP NOT NULL
);

CREATE TABLE CAR
(
    id NUMBER PRIMARY KEY,
    model VARCHAR2(255) NOT NULL,
    horsepower NUMBER NOT NULL,
    owner_id NUMBER NOT NULL,
    FOREIGN KEY (owner_id) REFERENCES person (id) ON DELETE CASCADE
);

INSERT INTO PERSON (id, name, birthdate)
VALUES (1, 'Sergey', '2000-08-09'),
       (2, 'Igor', '1980-06-30'),
       (3, 'Diana', '2001-09-08');

INSERT INTO CAR (id, model, horsepower, owner_id)
VALUES (1, 'BMW-X5', 199, 1),
       (2, 'Bmw-i8', 250, 1),
       (3, 'Ford-Focus 2 restyling', 99, 2),
       (4, 'MINI-Cooper', 150, 3),
       (5, 'mini-countryman', 210, 3),
       (6, 'porsche-Panamera', 340, 2);