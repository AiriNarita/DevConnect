package com.example.DevConnect.infrastructure.dto

/**
 * ArticleDto 記事DTOクラス
 * @property articleId 記事ID
 * @property userId ユーザーID
 * @property content 記事の内容
 * @property title タイトル
 * @property imageUrl 画像URL
 * @property publicStatus 公開ステータス
 * @property version バージョン
 */
data class ArticleDto(
    val articleId: Int?,
    val userId: Int,
    val content: String,
    val title: String,
    val imageUrl: String?,
    val publicStatus: String,
    val version: Int
)