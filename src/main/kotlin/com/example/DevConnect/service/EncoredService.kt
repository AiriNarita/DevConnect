package com.example.DevConnect.service

import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

/**
 * パスワードのエンコードクラス
 * @property passwordEncoder パスワードエンコーダー
 */
@Service
class EncoredService(
    private val passwordEncoder: PasswordEncoder
) {
    /**
     * パスワードのエンコード
     * @param password パスワード
     * @return エンコード後のパスワード
     */
    fun encode(password: String): String {
        return passwordEncoder.encode(password)
    }

    /**
     * パスワードのマッチング
     * @param rawPassword 入力されたパスワード
     * @param encodedPassword DBにあるエンコードされたパスワード
     * @return パスワードが一致するかどうか
     */
    fun matches(rawPassword: String, encodedPassword: String): Boolean {
        return passwordEncoder.matches(rawPassword, encodedPassword)
    }
}