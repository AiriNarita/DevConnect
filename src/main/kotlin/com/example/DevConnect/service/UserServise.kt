package com.example.DevConnect.service

import com.example.DevConnect.domain.model.entity.user.UserEntity
import com.example.DevConnect.domain.repository.user.UserRepository
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
    fun createUser(userEntity: UserEntity): Result<UserEntity> {
        return userRepository.createUser(userEntity)
    }
}