package com.example.DevConnect.adapter.controller

import com.example.DevConnect.configuration.CustomUserDetails
import com.example.DevConnect.domain.model.entity.article.ArticleEntity
import com.example.DevConnect.infrastructure.dto.ArticleDto
import com.example.DevConnect.service.ArticleService
import org.seasar.doma.jdbc.Result
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

/**
 * ArticleController 記事コントローラー
 * @property articleService ArticleService
 */
@Controller
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
        val authentication = SecurityContextHolder.getContext().authentication
        val userId = (authentication.principal as CustomUserDetails).id ?: throw Exception("ユーザーIDが取得できませんでした")

        val articleDtoWithUserId = articleDto.copy(userId = userId)
        return articleService.create(articleDtoWithUserId)
    }

    /**
     * 記事の全件取得
     * @return 記事エンティティ
     */
    @GetMapping("")
    fun findAllArticle(): List<ArticleEntity> {
        return articleService.findAllArticle()
    }

    /**
     * 記事のIDで取得
     * @param id ID
     * @return 記事エンティティ
     */
    @GetMapping("/{id}")
    fun findById(@PathVariable id: Int): ArticleEntity {
        return articleService.findById(id)
    }

}