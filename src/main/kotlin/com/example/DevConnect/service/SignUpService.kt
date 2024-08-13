package com.example.DevConnect.service

import com.example.DevConnect.configration.logger
import com.example.DevConnect.domain.factory.user.UserFactory
import com.example.DevConnect.domain.model.entity.user.UserEntity
import com.example.DevConnect.domain.repository.user.UserRepository
import com.example.DevConnect.infrastructure.dto.UserSignUpForm
import org.seasar.doma.jdbc.Result
import org.springframework.stereotype.Service

@Service
class SignUpService(
    private val userRepository: UserRepository,
    private val encoredService: EncoredService,
    private val userValidation: UserValidation
){
    companion object{
        private val log = logger()
    }

    /**
     * ユーザーの作成
     * @param userForm ユーザー登録フォーム
     * @return ユーザーエンティティ
     */
    fun createUser(userForm: UserSignUpForm): Result<UserEntity> {

        // ユーザー名のバリデーション
        if (!userValidation.validateUserName(userForm.name)){
            return Result(0, null)
        }
        // パスワードをエンコード
        val encodedPassword = encoredService.encode(userForm.password)
        val userEntity = UserFactory.from(userForm.copy(password = encodedPassword))
        return userRepository.createUser(userEntity)
    }
}