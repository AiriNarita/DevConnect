package com.example.DevConnect.service

import com.example.DevConnect.domain.factory.user.UserFactory
import com.example.DevConnect.domain.model.entity.user.UserEntity
import com.example.DevConnect.domain.repository.user.UserRepository
import com.example.DevConnect.infrastructure.dto.UserLoginForm
import com.example.DevConnect.infrastructure.dto.UserSignUpForm
import org.seasar.doma.jdbc.Result
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.stereotype.Service

@Service
class UserServise(
    private val userRepository: UserRepository,
    private val encordService: EncordService

) {

    /**
     * ユーザーの作成
     * @param userEntity ユーザーエンティティ
     * @return ユーザーエンティティ
     */
    fun createUser(userForm: UserSignUpForm): Result<UserEntity> {
        val userEntity = UserFactory.from(userForm)
        return userRepository.createUser(userEntity)
    }

    /**
     * ユーザーの取得
     * @param username ユーザー名
     */
    fun findByUsername(userForm: UserLoginForm): UserEntity? {
        val userEntity = userRepository.findByUsername(userForm.username)
            ?: throw IllegalArgumentException("ユーザーが見つかりません")

        if (!encordService.matches(userEntity.password, userForm.password)) {
            throw IllegalArgumentException("パスワードが違います")
        }
        return userEntity
    }
}