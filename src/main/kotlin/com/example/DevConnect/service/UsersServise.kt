package com.example.DevConnect.service

import com.example.DevConnect.domain.factory.user.UserFactory
import com.example.DevConnect.domain.model.entity.user.UserEntity
import com.example.DevConnect.domain.repository.user.UserRepository
import com.example.DevConnect.infrastructure.dto.UserLoginForm
import com.example.DevConnect.infrastructure.dto.UserSignUpForm
import org.seasar.doma.jdbc.Result
import org.springframework.stereotype.Service

@Service
class UsersServise(
    private val userRepository: UserRepository,
    private val encordService: EncordService

){

    /**
     * ユーザーの作成
     * @param userEntity ユーザーエンティティ
     * @return ユーザーエンティティ
     */
    fun createUser(userForm: UserSignUpForm): Result<UserEntity> {
        // パスワードをエンコード
        val encodedPassword = encordService.encode(userForm.password)
        val userEntity = UserFactory.from(userForm.copy(password = encodedPassword))
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

    /**
     * ログイン処理
     * @param userForm ユーザーログインフォーム
     */
    fun authenticateUser(userForm: UserLoginForm): UserEntity {
        val userEntity = userRepository.findByUsername(userForm.username)
            ?: throw IllegalArgumentException("ユーザーが見つかりません")

        if (!encordService.matches(userForm.password, userEntity.password)) {
            throw IllegalArgumentException("パスワードが違います")
        }
        return userEntity
    }
}