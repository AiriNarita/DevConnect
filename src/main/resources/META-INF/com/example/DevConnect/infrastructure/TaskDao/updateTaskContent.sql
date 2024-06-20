UPDATE tasks
SET
    goal_id = /* taskEntity.goalId */0,
    parent_task_id = /* taskEntity.parentTaskId */0,
    description = /* taskEntity.description */'',
    priority = /* taskEntity.priority */'',
    due_date = /* taskEntity.dueDate */null,
    completed = /* taskEntity.completed */false,
WHERE
    task_id = /* taskEntity.taskId */0
