package com.example.DevConnect.adapter.controller

import com.example.DevConnect.configration.logger
import com.example.DevConnect.domain.model.entity.user.UserEntity
import com.example.DevConnect.infrastructure.dto.UserSignUpForm
import com.example.DevConnect.service.EncordService
import com.example.DevConnect.service.UsersServise
import org.seasar.doma.jdbc.Result
import org.springframework.stereotype.Controller
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/")
class AuthController(
    private val userServise: UsersServise,
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

    /**
     * ログイン処理
     */
//    @PostMapping("/login")
//    fun login(
//        @ModelAttribute userForm: UserLoginForm,
//    ) : String{
//        try {
//            // ユーザーを認証
//            val userEntity = userServise.authenticateUser(userForm)
//
//            // Spring Securityの認証コンテキストに設定
//            val authentication = UsernamePasswordAuthenticationToken(
//                userEntity.username, userEntity.password, listOf() // 権限リストを適切に設定
//            )
//            SecurityContextHolder.getContext().authentication = authentication
//
//            return "redirect:/home" // ログイン成功後のリダイレクト先
//
//        } catch (e: IllegalArgumentException) {
//            // 認証失敗時にエラーメッセージを表示
//            return "redirect:/login?error"
//        }
//    }
}