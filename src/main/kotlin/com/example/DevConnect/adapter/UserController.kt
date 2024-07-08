package com.example.DevConnect.adapter

import com.example.DevConnect.domain.model.entity.UserEntity
import com.example.DevConnect.domain.service.UserServise
import org.seasar.doma.jdbc.Result
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * UserController ユーザーコントローラ
 */
@RestController
@RequestMapping("/users")
class UserController(
    private val userService: UserServise
) {
    /**
     * ユーザーの作成
     * @param userEntity ユーザーエンティティ
     * @return ユーザーエンティティ
     */
    @PostMapping("")
    fun createUser(
        @RequestBody userEntity: UserEntity
    ): Result<UserEntity> {
        return userService.createUser(userEntity)
    }
}