package com.example.DevConnect.service

import com.example.DevConnect.domain.factory.article.ArticleFactory
import com.example.DevConnect.domain.model.entity.article.ArticleEntity
import com.example.DevConnect.domain.repository.article.ArticleRepository
import com.example.DevConnect.infrastructure.dto.ArticleDto
import org.springframework.stereotype.Service
import org.seasar.doma.jdbc.Result

@Service
class ArticleService(
    private val articleRepository: ArticleRepository,
    private val articleFactory: ArticleFactory
) {

    /**
     * 登録する
     * @param articleDTO 記事DTO
     * @return 記事エンティティ
     */
    fun create(articleDto: ArticleDto):  Result<ArticleEntity> {
        val entity = articleFactory.from(articleDto)
        return articleRepository.create(entity)
    }
    /**
     * 全件取得する
     * @param articleEntity 記事エンティティ
     * @return 記事エンティティ
     */
    fun findAllArticle():  List<ArticleEntity> {
        return articleRepository.findAllArticle()
    }
}