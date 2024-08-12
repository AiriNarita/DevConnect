package com.example.DevConnect.adapter.controller

import com.example.DevConnect.configration.CustomUserDetails
import com.example.DevConnect.domain.model.entity.user.UserEntity
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
    private val userServise: UserServise
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

    @PostMapping("/login")
    fun login(): String {
        println("login")
        val userDetails = SecurityContextHolder.getContext().authentication.principal as CustomUserDetails
        return userDetails.username
    }

    /**
     * サインアップページの表示
     */
    @GetMapping("/signup")
    fun sighupPage(): String {
        return "signup"
    }

    @PostMapping("/signup")
    fun sighup(
        @RequestBody userEntity: UserEntity
    ): Result<UserEntity> {
        println("sighupします")
        try {
            return userServise.createUser(userEntity)
        } catch (e: Exception) {
            throw e
        }
    }
}