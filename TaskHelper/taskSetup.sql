--DROP TABLE users;
--
--CREATE TABLE users(
--	id   INT GENERATED ALWAYS AS IDENTITY,
--	email  VARCHAR(100),
--	password VARCHAR(200),
--	user_name VARCHAR(50),
--	user_contact VARCHAR(100),
--	user_type INT,
--	PRIMARY KEY (id)
--);


--DROP TABLE tasks;
--
--CREATE TABLE tasks(
--	task_id   INT GENERATED ALWAYS AS IDENTITY,
--	customer_id INT,
--	expert_id INT,
--	task_name  VARCHAR(50),
--	task_date DATE,
--	task_time TIME,
--	location VARCHAR(50),
--	contact VARCHAR(50),
--	task_description VARCHAR(200),
--	budget FLOAT,
--	task_status INT,	
--	PRIMARY KEY (task_id),
--	FOREIGN KEY (customer_id) REFERENCES users (id),
--	FOREIGN KEY (expert_id) REFERENCES users (id)
--);

--INSERT INTO users (email, password, user_name, user_contact, user_type)
--VALUES ('mike@gmail.com', '123456', 'Mike Stone', '0413232232', 0);
--INSERT INTO users (email, password, user_name, user_contact, user_type)
--VALUES ('frank@gmail.com', '123456', 'Frank Smith', '0413676676', 1);

INSERT INTO tasks (customer_id, expert_id, task_name, task_date, task_time, location, contact,
task_description, budget, task_status)
VALUES (1, 2, 'HouseKeeping', '2019-09-20', '14:00:00', '610 Swanston st, Carlton', 
'0413232232', '1.Sweep the floor 2.Feed the pet', 30.0, 0);





