package com.example.DevConnect.domain.factory.article

import com.example.DevConnect.domain.model.entity.article.ArticleEntity
import com.example.DevConnect.infrastructure.dto.ArticleDto

class ArticleFactory {
    companion object {
        /**
         * 生成する
         *
         * @param dto 記事DTO
         * @return ArticleEntity
         */
        fun new(dto: ArticleDto): ArticleEntity {
            return ArticleEntity(
                articleId = dto.articleId,
                userId = dto.userId,
                content = dto.content,
                title = dto.title,
                imageUrl = dto.imageUrl,
                publicStatus = dto.publicStatus,
                version = 1
            )
        }
    }
}