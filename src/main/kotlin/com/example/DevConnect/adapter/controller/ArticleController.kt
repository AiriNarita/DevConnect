package com.example.DevConnect.adapter.controller

import com.example.DevConnect.domain.model.entity.article.ArticleEntity
import com.example.DevConnect.infrastructure.dto.ArticleDto
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
     * @param articleDto 記事DTO
     * @return 記事エンティティ
     */
    @PostMapping("")
    fun create(articleDto: ArticleDto): Result<ArticleEntity> {
        return articleService.create(articleDto)
    }

    /**
     * 記事の全件取得
     * @return 記事エンティティ
     */
    @GetMapping("")
    fun findAllArticle(): List<ArticleEntity> {
        return articleService.findAllArticle()
    }

}