package com.example.DevConnect.adapter.controller

import com.example.DevConnect.domain.model.entity.task.TaskEntity
import com.example.DevConnect.service.TaskService
import org.seasar.doma.jdbc.Result
import org.springframework.web.bind.annotation.*

/**
 * TaskController　タスクコントローラー
 * @property taskService TaskService
 */
@RestController
@RequestMapping("/tasks")
public class TaskController(
     private val taskService: TaskService
) {

    /**
     * タスクを全件取得する
     * @return タスクリスト
     */
    @GetMapping("")
    fun findAll(): List<TaskEntity>{
        return taskService.findAll()
    }

    /**
     * タスクを1件取得する
     * @return タスクエンティティ
     */
    @GetMapping("/{taskId}")
    fun findById(
        @PathVariable("taskId") id: Long
    ): TaskEntity {
        return taskService.findById(id)
    }

    /**
     * タスクを作成する
     * @return タスクエンティティ
     */
    @PostMapping("")
    fun create(
        @RequestBody taskEntity: TaskEntity
    ): Result<TaskEntity> {
        return taskService.createTask(taskEntity)
    }

    /**
     * タスクを削除する
     * @return タスクエンティティ
     */
    @DeleteMapping("/{taskId}")
    fun deleteTask(
        @PathVariable("taskId") id: Long
    ): Int {
        return taskService.deleteTask(id)
    }

    /**
     * タスクのステータスを更新する
     * @return taskId
     */
    @PutMapping("/{taskId}")
    fun updateTaskStatus(
        @PathVariable("taskId") id: Long
    ): TaskEntity {
        return taskService.updateTaskStatus(id)
    }

    /**
     * タスクの内容を更新する
     *　
     */
    @PutMapping("/update/{taskId}")
    fun updateTaskContent(
        @PathVariable("taskId") id: Long,
        @RequestBody taskEntity: TaskEntity
    ): Result<TaskEntity> {
        return taskService.updateTaskContent(taskEntity)
    }

}