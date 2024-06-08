package com.example.DevConnect.domain.model.entity

import org.seasar.doma.*
import java.time.LocalDate
import java.time.LocalDateTime


@Entity(immutable = true)
@Table(name = "tasks")
data class TaskEntity(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val taskId: Int? = null,

        val goalId: Int? = null,

        val parentTaskId: Int? = null,

        val description: String? = null,

        val priority: Int? = null,

        val dueDate: LocalDate? = null,

        val completed: Boolean? = null,

        val createdAt: LocalDateTime = LocalDateTime.now(),

        val updatedAt: LocalDateTime = LocalDateTime.now(),

        @Version
        @Column(name = "version")
        val version: Int
    )