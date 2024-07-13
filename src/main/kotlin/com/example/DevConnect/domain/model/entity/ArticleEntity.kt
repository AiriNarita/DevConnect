package com.example.DevConnect.domain.model.entity

import com.example.DevConnect.infrastructure.dto.ArticleDto
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

    @Column(name = "public_status")
    val publicStatus:  ArticleStatus= ArticleStatus.Public,

    @Column(name = "version")
    val version: Int
){
    companion object {
        fun fromDTO(dto: ArticleDto): ArticleEntity {
            return ArticleEntity(
                articleId = dto.articleId,
                userId = dto.userId,
                content = dto.content,
                title = dto.title,
                imageUrl = dto.imageUrl,
                publicStatus = when (dto.publicStatus) {
                    "DRAFT" -> ArticleStatus.Draft
                    "PUBLIC" -> ArticleStatus.Public
                    "ARCHIVED" -> ArticleStatus.Archived
                    else -> throw IllegalArgumentException("Unknown status: ${dto.publicStatus}")
                },
                version = dto.version
            )
        }

        fun toDTO(entity: ArticleEntity): ArticleDto {
            return ArticleDto(
                articleId = entity.articleId,
                userId = entity.userId,
                content = entity.content,
                title = entity.title,
                imageUrl = entity.imageUrl,
                publicStatus = when (entity.publicStatus) {
                    is ArticleStatus.Draft -> "DRAFT"
                    is ArticleStatus.Public -> "PUBLIC"
                    is ArticleStatus.Archived -> "ARCHIVED"
                },
                version = entity.version
            )
        }
    }
}
