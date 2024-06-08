package com.example.DevConnect.domain.model.entity

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
        val taskId: Int? = null,

        val goalId: Int? = null,

        val parentTaskId: Int? = null,

        val description: String? = null,

        val priority: Priority? = null,

        val dueDate: LocalDate? = null,

        val completed: Boolean? = null,

        val createdAt: LocalDateTime = LocalDateTime.now(),

        val updatedAt: LocalDateTime = LocalDateTime.now(),

        @Version
        @Column(name = "version")
        val version: Int
    )