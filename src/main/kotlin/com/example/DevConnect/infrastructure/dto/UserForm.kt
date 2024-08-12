package com.example.DevConnect.infrastructure.dto

/**
 * ユーザーフォーム
 * @property name 名前
 * @property email メールアドレス
 * @property password パスワード
 */
data class UserForm(
    var name: String,
    var email: String,
    var password: String
)