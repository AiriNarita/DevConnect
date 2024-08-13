package com.example.DevConnect.infrastructure.dto

/**
 * ユーザーログインフォーム
 * @property username ユーザー名
 * @property password パスワード
 */
data class UserLoginForm(
    var username: String,
    var password: String
)