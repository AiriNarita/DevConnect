CREATE TABLE tasks (
    task_id INT PRIMARY KEY,
    goal_id INT,
    parent_task_id INT,
    description TEXT NULL,
    priority INT NULL,
    due_date DATE NULL,
    completed BOOLEAN NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    version INT NOT NULL
);