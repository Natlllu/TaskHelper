DROP TABLE users;
 
CREATE TABLE users(
     id   INT GENERATED ALWAYS AS IDENTITY,
     email  VARCHAR(100),
     password VARCHAR(200),
     user_name VARCHAR(50),
     user_contact VARCHAR(100),
     user_type INT,
     PRIMARY KEY(id)
);


