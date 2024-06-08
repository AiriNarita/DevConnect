package com.example.DevConnect.adapter

import com.example.DevConnect.domain.model.entity.TaskEntity
import com.example.DevConnect.domain.service.TaskService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

/**
 * TaskController
 * @property taskService TaskService
 */
@Controller
@RequestMapping("/todos")
public class TaskController(
     private val taskService: TaskService
) {

    @GetMapping("")
    fun findAll(): List<TaskEntity>{
        return taskService.findAll()
    }

}