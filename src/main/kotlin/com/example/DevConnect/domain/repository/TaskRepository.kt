package com.example.DevConnect.domain.repository

import com.example.DevConnect.domain.model.entity.TaskEntity
import com.example.DevConnect.infrastructure.TaskDao
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
}