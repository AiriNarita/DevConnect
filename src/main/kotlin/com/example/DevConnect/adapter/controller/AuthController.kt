package com.example.DevConnect.adapter.controller

import com.example.DevConnect.configration.logger
import com.example.DevConnect.domain.model.entity.user.UserEntity
import com.example.DevConnect.infrastructure.dto.UserSignUpForm
import com.example.DevConnect.service.EncordService
import com.example.DevConnect.service.SignUpServise
import org.seasar.doma.jdbc.Result
import org.springframework.stereotype.Controller
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/")
class AuthController(
    private val userServise: SignUpServise,
    private val encordService: EncordService
) {
    companion object {
        val log = logger()
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
        @ModelAttribute userForm: UserSignUpForm,
        bindingResult: BindingResult
    ): Result<UserEntity> {
        return userServise.createUser(userForm)
    }
}