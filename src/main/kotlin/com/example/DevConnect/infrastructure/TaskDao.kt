package com.example.DevConnect.infrastructure

import com.example.DevConnect.domain.model.entity.TaskEntity
import org.seasar.doma.Dao
import org.seasar.doma.Delete
import org.seasar.doma.Insert
import org.seasar.doma.Select
import org.seasar.doma.boot.ConfigAutowireable
import org.seasar.doma.jdbc.Result
import org.springframework.transaction.annotation.Transactional

/**
 *　TaskDao　タスクDAO
 *
 */
@Dao
@ConfigAutowireable
@Transactional
interface TaskDao {

    /**
     * タスクを全件取得する
     * @return タスクリスト
     */
    @Select
    fun findAll(): List<TaskEntity>

    /**
     * タスクを作成する
     * @return タスクエンティティ
     */
    @Insert(sqlFile = true)
    fun create(taskEntity: TaskEntity): Result<TaskEntity>

    /**
     * タスクを削除する
     */
    @Delete(sqlFile = true)
    fun deleteTask(id: Long): Int
}