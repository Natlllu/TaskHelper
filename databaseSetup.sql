DROP TABLE tasks;
CREATE TABLE tasks(
	task_id   INT GENERATED ALWAYS AS IDENTITY,
	customer_id INT,
	expert_id INT,
	task_name  VARCHAR(50),
	task_time TIMESTAMP,
	location VARCHAR(50),
	contact VARCHAR(50),
	task_description VARCHAR(200),
	budget FLOAT,
	task_status INT,
	PRIMARY KEY (task_id),
	FOREIGN KEY (customer_id) REFERENCES users (id),
	FOREIGN KEY (expert_id) REFERENCES users (id)
);



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




