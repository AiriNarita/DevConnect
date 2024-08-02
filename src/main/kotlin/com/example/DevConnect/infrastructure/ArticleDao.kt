package com.example.DevConnect.infrastructure

import com.example.DevConnect.domain.model.entity.article.ArticleEntity
import org.seasar.doma.Dao
import org.seasar.doma.Insert
import org.seasar.doma.Select
import org.seasar.doma.boot.ConfigAutowireable
import org.seasar.doma.jdbc.Result
import org.springframework.transaction.annotation.Transactional

/**
 * ArticleDao 記事DAOクラス
 * @property articleEntity ArticleEntity
 */
@Dao
@ConfigAutowireable
@Transactional
interface ArticleDao {

    /**
     * 登録する
     * @param articleEntity 記事エンティティ
     * @return 記事エンティティ
     */
    @Insert(sqlFile = true)
    fun create(articleEntity: ArticleEntity):  Result<ArticleEntity>

    /**
     * 全件取得する
     * @param articleEntity 記事エンティティ
     * @return 記事エンティティ
     */
    @Select
    fun findAllArticle():  List<ArticleEntity>

    /**
     * IDで取得する
     * @param id ID
     * @return 記事エンティティ
     */
    @Select
    fun findById(id: Int): Result<ArticleEntity>
}