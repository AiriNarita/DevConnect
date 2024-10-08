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
        * 半角英数字とハイフン、アンダースコアのみを許可
        * @param userName ユーザー名
        * @return バリデーション結果
        */
        fun validateUserName(userName: String): Boolean {
            return Regex("^[a-zA-Z0-9-_]+$").matches(userName)
        }

    /**
     * emailのバリデーション
     * 半角英数字とハイフン、アンダースコアのみを許可
     *
     * @param email メールアドレス
     * @return バリデーション結果
     */
    fun validateEmail(email: String): Boolean {
        return Regex("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$").matches(email)
    }

    /**
     * passwordのバリデーション
     */
    fun validatePassword(password: String): Boolean {
        val length = password.length >=8
        return length && Regex("^[a-zA-Z0-9-_]+$").matches(password)
    }

}