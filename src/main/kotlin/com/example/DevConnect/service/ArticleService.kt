package com.example.DevConnect.service

import com.example.DevConnect.domain.factory.article.ArticleFactory
import com.example.DevConnect.domain.model.entity.article.ArticleEntity
import com.example.DevConnect.domain.repository.article.ArticleRepository
import com.example.DevConnect.infrastructure.dto.ArticleDto
import org.seasar.doma.jdbc.Result
import org.springframework.stereotype.Service

@Service
class ArticleService(
    private val articleRepository: ArticleRepository,
) {

    /**
     * 登録する
     * @param articleDto 記事DTO
     * @return 記事エンティティ
     */
    fun create(articleDto: ArticleDto):  Result<ArticleEntity> {
        val entity = ArticleFactory.from(articleDto)
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

    /**
     * IDで取得する
     * @param id ID
     * @return 記事エンティティ
     */
    fun findById(id: Int): ArticleEntity {
        return articleRepository.findById(id)
    }

    fun delete(id: Int): Result<ArticleEntity> {
        return articleRepository.delete(id)
    }

    fun update(id: Int): Result<ArticleEntity> {
        // 未実装
    }
}