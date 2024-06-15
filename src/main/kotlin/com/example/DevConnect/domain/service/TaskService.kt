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
    fun deleteTask(taskEntity: TaskEntity): Result<TaskEntity> {
        return taskRepository.deleteTask(taskEntity)
    }


}