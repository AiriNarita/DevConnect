package com.example.DevConnect.domain.model.entity

sealed class ArticleStatus {
    object Draft : ArticleStatus()
    object Public : ArticleStatus()
    object Archived : ArticleStatus()
}