UPDATE tasks
SET description = /*description*/'',
    priority = /*priority*/'',
    due_date = /*dueDate*/'',
    updated_at = CURRENT_TIMESTAMP
WHERE task_id = /*taskId*/0;