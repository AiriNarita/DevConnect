package com.example.DevConnect.domain.model.entity

import org.seasar.doma.*
import org.seasar.doma.jdbc.entity.NamingType
import java.time.LocalDateTime

/**
 * ArticleEntity 記事エンティティ
 * @property articleId 記事Id
 * @property userId ユーザーId
 * @property content 記事の内容
 * @property title タイトル
 * @property imageUrl 画像URL
 * @property isDraft 下書きフラグ
 * @property isPublic 公開フラグ
 * @property createdAt 作成日時
 * @property updatedAt 更新日時
 * @property version バージョン
 */
@Entity(immutable = true)
//, naming = NamingType.SNAKE_LOWER_CASEつけて@Columnを消す
@Table(name = "articles")
data class ArticleEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "article_id")
    val articleId: Int? = null,
    @Column(name = "user_id")
    val userId: Int,
    @Column(name = "content")
    val content: String,
    @Column(name = "title")
    val title: String,
    @Column(name = "image_url")
    val imageUrl: String?,
    @Column(name = "is_draft")
    val isDraft: Boolean,
    @Column(name = "is_public")
    val isPublic: Boolean,
    @Column(name = "created_at")
    val createdAt: LocalDateTime = LocalDateTime.now(),
    @Column(name = "updated_at")
    val updatedAt: LocalDateTime = LocalDateTime.now(),
    @Column(name = "version")
    val version: Int
)
