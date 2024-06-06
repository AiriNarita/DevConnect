package com.example.DevConnect.infrastructure

import TaskEntity
import org.seasar.doma.Dao
import org.seasar.doma.Select
import org.seasar.doma.boot.ConfigAutowireable
import org.springframework.context.annotation.Configuration
import org.springframework.transaction.annotation.Transactional

@Dao
@ConfigAutowireable
@Transactional
interface TaskDao {

    @Select
    fun findAll(): List<TaskEntity>


}