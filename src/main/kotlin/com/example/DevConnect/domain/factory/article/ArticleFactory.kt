package com.example.DevConnect.domain.factory.article

import com.example.DevConnect.adapter.dto.ArticleDTO
import com.example.DevConnect.domain.model.entity.article.ArticleEntity

class ArticleFactory {

    /**
     * 生成する
     * @param dto 記事DTO
     * @return ArticleEntity
     */
    fun from(dto: ArticleDTO): ArticleEntity {
        return ArticleEntity(
            userId = dto.userId,
            content = dto.content,
            title = dto.title,
            imageUrl = dto.imageUrl,
            publicStatus = dto.publicStatus,
            version = 1
        )
    }
}