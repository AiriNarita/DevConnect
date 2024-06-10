package com.example.DevConnect.domain.service

import com.example.DevConnect.domain.model.entity.UserEntity
import com.example.DevConnect.domain.repository.UserRepository
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