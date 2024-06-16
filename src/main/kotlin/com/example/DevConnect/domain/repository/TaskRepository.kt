package com.example.DevConnect.domain.repository

import com.example.DevConnect.domain.model.entity.TaskEntity
import com.example.DevConnect.infrastructure.TaskDao
import org.seasar.doma.jdbc.Result
import org.springframework.stereotype.Repository

@Repository
class TaskRepository(
    private val taskDao: TaskDao
) {
    /**
     * タスクを全件取得する
     * @return タスクリスト
     */
    fun findAll(): List<TaskEntity>{
        return taskDao.findAll()
    }

    /**
     * タスクを作成する
     * @return タスクエンティティ
     */
    fun createTask(taskEntity: TaskEntity): Result<TaskEntity> {
        return taskDao.create(taskEntity)
    }

    /**
     * タスクを削除する
     * @return タスクエンティティ
     */
fun deleteTask(id: Long): Int {
        return taskDao.deleteTask(id)
    }

    /**
     * タスクのステータスを更新する
     * @return taskId
     */
    fun updateTaskStatus(taskId: Long): Int {
        return taskDao.updateTaskStatus(taskId)
    }

    /**
     * タスクを1件取得する
     */
    fun findById(id: Long): TaskEntity {
        return taskDao.findById(id)
    }
}