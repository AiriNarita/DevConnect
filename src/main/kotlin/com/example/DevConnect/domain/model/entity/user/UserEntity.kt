package com.example.DevConnect.domain.model.entity.user

import lombok.NonNull
import org.seasar.doma.*
import java.time.LocalDateTime

/**
 * UserEntity ユーザーエンティティ
 *
 * @property userId ユーザーID
 * @property username ユーザー名
 * @property email メールアドレス
 * @property password パスワード
 * @property createdAt 作成日時
 * @property updatedAt 更新日時
 * @property version バージョン
 * @property userStatus ユーザーステータス
 */

@Entity(immutable = true)
@Table(name = "users")
data class UserEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    val userId: Int? = null,

    @NonNull
    val username: String,

    @NonNull
    val email: String,

    @NonNull
    val password: String,

    @Column(name = "created_at")
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @Column(name = "updated_at")
    val updatedAt: LocalDateTime = LocalDateTime.now(),

    @Version
    @Column(name = "version")
    val version: Int,

    @Column(name = "user_status")
    val userStatus: UserStatusEnum,

    @Column(name = "role")
    val role: UserRole,
)
