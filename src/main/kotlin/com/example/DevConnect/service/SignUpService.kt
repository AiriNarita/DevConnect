package com.example.DevConnect.service

import OperationResult
import com.example.DevConnect.configration.logger
import com.example.DevConnect.domain.factory.user.UserFactory
import com.example.DevConnect.domain.model.entity.user.UserEntity
import com.example.DevConnect.domain.repository.user.UserRepository
import com.example.DevConnect.infrastructure.dto.UserSignUpForm
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
    fun createUser(userForm: UserSignUpForm): OperationResult<UserEntity, String>{

            val existingUser = userRepository.findByUsername(userForm.username)
            if (existingUser != null) {
                return OperationResult.failure("ユーザー名が既に存在します")
            }
            if (! userValidation.validateUserName(userForm.username) )
                return OperationResult.failure("ユーザー名は半角英数字とハイフン、アンダースコアのみを許可します")

            // パスワードをエンコード
            val encodedPassword = encoredService.encode(userForm.password)
            val userEntity = UserFactory.from(userForm.copy(password = encodedPassword))
            userRepository.createUser(userEntity)

            return OperationResult.success(userEntity)
    }
}