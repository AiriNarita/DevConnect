package com.example.DevConnect.domain.service

import com.example.DevConnect.domain.model.entity.TaskEntity
import com.example.DevConnect.domain.repository.TaskRepository
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
}