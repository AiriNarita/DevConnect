package com.example.DevConnect.domain.repository.article

import com.example.DevConnect.domain.model.entity.article.ArticleEntity
import com.example.DevConnect.infrastructure.ArticleDao
import org.seasar.doma.jdbc.Result
import org.springframework.stereotype.Repository

@Repository
class ArticleRepository(
    private val articleDao: ArticleDao
) {
    /**
     * 登録する
     * @param articleEntity 記事エンティティ
     * @return 記事エンティティ
     */
    fun create(articleEntity: ArticleEntity): Result<ArticleEntity> {
        return articleDao.create(articleEntity)
    }

    /**
     * 全件取得する
     * @return 記事エンティティ
     */
    fun findAllArticle(): List<ArticleEntity> {
        return articleDao.findAllArticle()
    }

    /**
     * IDで取得する
     * @param id ID
     * @return 記事エンティティ
     */
    fun findById(id: Int):ArticleEntity {
        return articleDao.findById(id)
    }

    /**
     * 削除する
     * @param id ID
     */
    fun delete(id: Int): Result<ArticleEntity> {
        val entity = articleDao.findById(id)
        return articleDao.delete(entity)
    }


    /**
     * 記事を更新する
     */
    fun update(articleEntity: ArticleEntity): Result<ArticleEntity> {
        return articleDao.update(articleEntity)
    }
}