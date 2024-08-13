package com.example.DevConnect.domain.factory.user

import com.example.DevConnect.domain.model.entity.user.UserEntity
import com.example.DevConnect.domain.model.entity.user.UserRole
import com.example.DevConnect.domain.model.entity.user.UserStatusEnum
import com.example.DevConnect.infrastructure.dto.UserSignUpForm
import java.time.LocalDateTime

/**
 * ユーザー生成ファクトリークラス
 */
class UserFactory(
) {
    companion object {
        /**
         * 生成する
         *
         * @param userForm ユーザーフォーム
         * @return UserEntity
         */
        fun from(userForm: UserSignUpForm): UserEntity {
            return UserEntity(
                userId = null,
                username = userForm.name,
                email = userForm.email,
                password = userForm.password,
                version = 1,
                userStatus = UserStatusEnum.ACTIVE,
                role = UserRole.USER,
                createdAt = LocalDateTime.now(),
                updatedAt = LocalDateTime.now(),
            )
        }
    }
}