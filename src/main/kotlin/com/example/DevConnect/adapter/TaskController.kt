package com.example.DevConnect.adapter

import com.example.DevConnect.domain.model.entity.TaskEntity
import com.example.DevConnect.domain.service.TaskService
import org.springframework.stereotype.Controller
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
     * タスクを作成する
     * @return タスクエンティティ
     */
//    @PostMapping("")
//    fun create(
//        @RequestBody taskEntity: TaskEntity
//    ): Result<TaskEntity>{
//        return taskService.createTask(taskEntity)
//    }



}