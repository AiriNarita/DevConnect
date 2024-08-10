package com.example.DevConnect.adapter.dto

import com.example.DevConnect.domain.model.entity.article.ArticleStatus

/**
 * ArticleDTO 記事作成のためのDTOクラス
 * @property userId ユーザーID
 * @property content 記事の内容
 * @property title タイトル
 * @property imageUrl 画像URL
 * @property publicStatus 公開ステータス
 */
data class ArticleDTO(
    val userId: Int,
    val content: String,
    val title: String,
    val imageUrl: String? = null,
    val publicStatus: ArticleStatus
)
