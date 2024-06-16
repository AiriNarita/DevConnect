package com.example.DevConnect.domain.service

import com.example.DevConnect.domain.model.entity.TaskEntity
import com.example.DevConnect.domain.repository.TaskRepository
import org.seasar.doma.jdbc.Result
import org.springframework.stereotype.Service

/**
 * タスクサービス
 * @property taskRepository タスクリポジトリ
 */
@Service
class TaskService(
    private val taskRepository: TaskRepository
) {

    /**
     * タスクを全件取得する
     * @return タスクリスト
     */
    fun findAll(): List<TaskEntity> {
        return taskRepository.findAll()
    }

    /**
     * タスクを1件取得する
     */
    fun findById(taskId: Long): TaskEntity {
        return taskRepository.findById(taskId)
    }

    /**
     * タスクを作成する
     * @return タスクエンティティ
     */
    fun createTask(taskEntity: TaskEntity): Result<TaskEntity> {
        return taskRepository.createTask(taskEntity)
    }

    /**
     * タスクを削除する
     * @return タスクエンティティ
     */
    fun deleteTask(taskId: Long): Int {
        return taskRepository.deleteTask(taskId)
    }

    /**
     * タスクのステータスを更新する
     * @return taskId
     */
    fun updateTaskStatus(taskId: Long): TaskEntity {
        taskRepository.updateTaskStatus(taskId)
        return taskRepository.findById(taskId)
    }
}