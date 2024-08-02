package com.example.DevConnect.adapter.controller

import com.example.DevConnect.domain.model.entity.article.ArticleEntity
import com.example.DevConnect.service.ArticleService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import org.seasar.doma.jdbc.Result
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

/**
 * ArticleController 記事コントローラー
 * @property articleService ArticleService
 */
@RestController
@RequestMapping("/articles")
class ArticleController(
    private val articleService: ArticleService
) {
    /**
     * 記事の登録
     * @param articleEntity 記事エンティティ
     * @return 記事エンティティ
     */
    @PostMapping("")
    fun create(articleEntity: ArticleEntity): Result<ArticleEntity> {
        println(articleEntity)
        return articleService.create(articleEntity)
    }

    /**
     * 記事の全件取得
     * @param articleEntity 記事エンティティ
     * @return 記事エンティティ
     */
    @GetMapping("")
    fun findAllArticle(): List<ArticleEntity> {
        return articleService.findAllArticle()
    }

}