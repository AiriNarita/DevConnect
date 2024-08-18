CREATE TABLE tasks (
    task_id INT AUTO_INCREMENT PRIMARY KEY,
    goal_id INT NULL,
    parent_task_id INT NULL,
    description TEXT NULL,
    priority VARCHAR(255) NULL,
    due_date DATE NULL,
    completed BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    version INT NOT NULL
);
