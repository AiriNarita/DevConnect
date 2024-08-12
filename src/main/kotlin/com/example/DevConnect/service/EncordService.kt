package com.example.DevConnect.service

import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

/**
 * パスワードのエンコードクラス
 */
@Service
class EncordService(
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
}