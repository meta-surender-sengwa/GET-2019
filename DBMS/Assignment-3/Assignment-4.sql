CREATE DATABASE zipCode;

USE zipCode;


CREATE TABLE state
(   id INT,
    name varchar(20),
    PRIMARY KEY(id)
);


CREATE TABLE city
(   id INT,
    name VARCHAR(20),
    zip VARCHAR(4),
    stateId INT,
    PRIMARY KEY(id),
    FOREIGN KEY(stateId) REFERENCES state(id)
);


INSERT INTO state VALUES(20, "rajasthan");
INSERT INTO state VALUES(10, "gujrat");

INSERT INTO city VALUES(1, "ajmer", "RJ01", 20);
INSERT INTO city VALUES(21, "nagaur", "RJ21", 20);
INSERT INTO city VALUES(14, "jaipur", "RJ14", 20);
INSERT INTO city VALUES(10, "surat", "GJ15", 10);


/*
    Consider a form where providing a Zip Code populates associated City and State. 
    Create appropriate tables and relationships for the same and write a SQL query for that returns a Resultset 
    containing Zip Code, City Names and States ordered by State Name and City Name.
*/

SELECT city.zip AS zip_Code, city.name AS city, state.name AS state
FROM city, state
WHERE state.id = city.stateID
ORDER BY state;


