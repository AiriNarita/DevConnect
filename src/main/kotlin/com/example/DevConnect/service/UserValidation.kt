package com.example.DevConnect.service

import com.example.DevConnect.domain.repository.user.UserRepository
import org.springframework.stereotype.Service

/**
 * ユーザーのバリデーション
 * @property userRepository ユーザーリポジトリ
 */
@Service
class UserValidation(
    private val userRepository: UserRepository
) {

        /**
        * ユーザー名のバリデーション
        * ユーザー名は1文字以上50文字以下で、半角英数字とハイフン、アンダースコアのみを許可し、ユニークであること
        * @param userName ユーザー名
        * @return バリデーション結果
        */
        fun validateUserName(userName: String): Boolean {
            val length = userName.length in 1..50
            val regex = Regex("^[a-zA-Z0-9-_]+$").matches(userName)
            val isUnique = userRepository.findByUsername(userName) == null
            return length && regex && isUnique
        }

}