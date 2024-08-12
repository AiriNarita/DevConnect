package com.example.DevConnect.infrastructure.dto

/**
 * ユーザーフォーム
 * @property name 名前
 * @property email メールアドレス
 * @property password パスワード
 */
data class UserForm(
    val name: String,
    val email: String,
    var password: String
)