package com.example.DevConnect.domain.model.entity

import lombok.NonNull
import org.seasar.doma.*
import java.time.LocalDateTime

@Entity(immutable = true)
@Table(name = "users")
data class UserEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    val userId: Int?= null,

    @NonNull
    val username: String? = null,

    @NonNull
    val email: String? = null,

    @NonNull
    val password: String? = null,

    @Column(name = "created_at")
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @Column(name = "updated_at")
    val updatedAt: LocalDateTime = LocalDateTime.now(),

    )