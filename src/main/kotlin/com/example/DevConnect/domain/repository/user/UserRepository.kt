package com.example.DevConnect.domain.repository.user

import com.example.DevConnect.domain.model.entity.user.UserEntity
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

    /**
     * ユーザーの取得
     * @param username ユーザー名
     * @return ユーザーエンティティ
     */
    fun findByUsername(username: String): UserEntity?{
        return userDao.findByUsername(username)
    }

    /**
     * emailの取得
     */
    fun findByEmail(email: String): UserEntity? {
        return userDao.findByEmail(email)
    }
}