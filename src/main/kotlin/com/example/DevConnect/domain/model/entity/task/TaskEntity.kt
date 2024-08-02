package com.example.DevConnect.domain.model.entity.task

import com.example.DevConnect.domain.model.entity.task.Priority
import jakarta.annotation.Nullable
import org.seasar.doma.*
import java.time.LocalDate
import java.time.LocalDateTime

/**
 * TaskEntity
 * @property taskId タスクId
 * @property goalId ゴールId
 * @property parentTaskId 親タスクId
 * @property description タスクの説明
 * @property priority 優先度
 * @property dueDate 期限日
 * @property completed 完了フラグ
 * @property createdAt 作成日時
 * @property updatedAt 更新日時
 * @property version バージョン
 */

@Entity(immutable = true)
@Table(name = "tasks")
data class TaskEntity(

    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "task_id")
        val taskId: Int? = null,

    @Nullable
        @Column(name = "goal_id")
        val goalId: Int? = null,

    @Nullable
        @Column(name = "parent_task_id")
        val parentTaskId: Int? = null,

    @Nullable
        @Column(name = "description")
        val description: String? = null,

    @Nullable
        @Column(name = "priority")
        val priority: Priority? = null,

    @Nullable
        @Column(name = "due_date")
        val dueDate: LocalDate? = null,

    val completed: Boolean? = false,

    @Column(name = "created_at")
        val createdAt: LocalDateTime = LocalDateTime.now(),

    @Column(name = "updated_at")
        val updatedAt: LocalDateTime = LocalDateTime.now(),

    @Version
        @Column(name = "version")
        val version: Int
    )