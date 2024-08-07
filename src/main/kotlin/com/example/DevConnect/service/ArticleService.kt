package com.example.DevConnect.service

import com.example.DevConnect.domain.model.entity.article.ArticleEntity
import com.example.DevConnect.domain.repository.article.ArticleRepository
import org.springframework.stereotype.Service
import org.seasar.doma.jdbc.Result

@Service
class ArticleService(
    private val articleRepository: ArticleRepository
) {

    /**
     * 登録する
     * @param articleEntity 記事エンティティ
     * @return 記事エンティティ
     */
    fun create(articleEntity: ArticleEntity):  Result<ArticleEntity> {
        return articleRepository.create(articleEntity)
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