package com.example.DevConnect.infrastructure.dto

/**
 * ユーザーフォーム
 * @property username 名前
 * @property email メールアドレス
 * @property password パスワード
 */
data class UserSignUpForm(
    val username: String,
    val email: String,
    var password: String
)