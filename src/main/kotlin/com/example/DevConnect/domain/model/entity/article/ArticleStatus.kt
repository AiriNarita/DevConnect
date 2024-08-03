package com.example.DevConnect.domain.model.entity.article

/**
 * ArticleStatus 記事ステータスENUMクラス
 * @property DRAFT 下書き
 * @property PUBLISHED 公開
 * @property DELETED 削除済み
 * @property ARCHIVE アーカイブ(非公開)
 */
enum class ArticleStatus {
    DRAFT,
    PUBLISHED,
    DELETED,
    ARCHIVE
}