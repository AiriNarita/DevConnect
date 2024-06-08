CREATE TABLE tasks (
    taskId INT PRIMARY KEY,
    goalId INT,
    parentTaskId INT,
    description TEXT NULL,
    priority ENUM('LOW', 'MEDIUM', 'HIGH') NULL,
    dueDate DATE NULL,
    completed BOOLEAN NULL,
    createdAt TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updatedAt TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    version INT NOT NULL
);