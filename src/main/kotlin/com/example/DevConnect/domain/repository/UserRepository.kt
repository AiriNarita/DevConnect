package com.example.DevConnect.domain.repository

import com.example.DevConnect.domain.model.entity.UserEntity
import com.example.DevConnect.infrastructure.UserDao
import org.seasar.doma.jdbc.Result
import org.springframework.stereotype.Repository

@Repository
class UserRepository(
    private val userDao: UserDao
) {

    /**
     * ユーザーの作成
     * @param userEntity ユーザーエンティティ
     * @return ユーザーエンティティ
     */
    fun createUser(userEntity: UserEntity): Result<UserEntity> {
        return userDao.createUser(userEntity)
    }
}