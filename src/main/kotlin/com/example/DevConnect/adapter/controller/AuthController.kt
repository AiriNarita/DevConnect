package com.example.DevConnect.adapter.controller

import com.example.DevConnect.configration.CustomUserDetails
import com.example.DevConnect.domain.model.entity.user.UserEntity
import com.example.DevConnect.infrastructure.dto.UserForm
import com.example.DevConnect.service.EncordService
import com.example.DevConnect.service.UserServise
import org.seasar.doma.jdbc.Result
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/")
class AuthController(
    private val userServise: UserServise,
    private val encordService: EncordService
) {
    companion object {
        //logger
    }

    /**
     * ログインページの表示
     */
    @GetMapping("/login")
    fun loginPage(): String {
        return "login"
    }
    /**
     * サインアップページの表示
     */
    @GetMapping("/signup")
    fun sighupPage(): String {
        return "signup"
    }

    /**
     * サインアップ処理
     */
    @PostMapping("/signup")
    fun signup(
        @RequestBody userForm: UserForm
    ): Result<UserEntity> {
        userForm.password = encordService.encode(userForm.password)
        try {
            return userServise.createUser(userForm)
        } catch (e: Exception) {
            throw e
        }
    }

    /**
     * ログイン処理
     */
    @PostMapping("/login")
    fun login(): String {
        println("login")
        val userDetails = SecurityContextHolder.getContext().authentication.principal as CustomUserDetails
        return userDetails.username
    }
}