package com.example.DevConnect.service

import com.example.DevConnect.domain.factory.user.UserFactory
import com.example.DevConnect.domain.model.entity.user.UserEntity
import com.example.DevConnect.domain.repository.user.UserRepository
import com.example.DevConnect.infrastructure.dto.UserForm
import org.seasar.doma.jdbc.Result
import org.springframework.stereotype.Service

@Service
class UserServise(
    private val userRepository: UserRepository
) {

    /**
     * ユーザーの作成
     * @param userEntity ユーザーエンティティ
     * @return ユーザーエンティティ
     */
    fun createUser(userForm: UserForm): Result<UserEntity> {
        val userEntity = UserFactory.from(userForm)
        return userRepository.createUser(userEntity)
    }

    /**
     * ユーザーの取得
     * @param username ユーザー名
     */
    fun findByUsername(username: String): UserEntity? {
        return userRepository.findByUsername(username)
    }
}