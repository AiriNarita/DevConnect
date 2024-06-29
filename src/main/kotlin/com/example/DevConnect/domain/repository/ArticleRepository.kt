package com.example.DevConnect.domain.repository

import com.example.DevConnect.infrastructure.ArticleDao
import org.springframework.stereotype.Repository

@Repository
class ArticleRepository(
    private val articleDao: ArticleDao

) {
}