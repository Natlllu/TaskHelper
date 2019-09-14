--CREATE TABLE tasks(
--	task_id   INT GENERATED ALWAYS AS IDENTITY,
--	customer_id INT,
--	expert_id INT,
--	task_name  VARCHAR(50),
--	task_time TIMESTAMP,
--	location VARCHAR(50),
--	contact VARCHAR(50),
--	task_description VARCHAR(200),
--	budget FLOAT,
--	task_status INT,
--	PRIMARY KEY (task_id),
--	FOREIGN KEY (customer_id) REFERENCES users (id),
--	FOREIGN KEY (expert_id) REFERENCES users (id)
--);

INSERT INTO tasks (customer_id, expert_id, task_name, task_time, location, contact,
task_description, budget, task_status)
VALUES (1, 2, 'HouseKeeping', '2019-09-20 14:00:00', '610 Swanston st, Carlton', 
'0413232232', '1.Sweep the floor 2.Feed the pet', 30.0, 0)
