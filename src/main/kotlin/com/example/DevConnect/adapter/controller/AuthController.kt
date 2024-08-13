package com.example.DevConnect.adapter.controller

import com.example.DevConnect.configration.logger
import com.example.DevConnect.infrastructure.dto.UserSignUpForm
import com.example.DevConnect.service.EncordService
import com.example.DevConnect.service.SignUpServise
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
    ): String{
       val result = userServise.createUser(userForm)
        if(result.count > 0){
            log.info("ユーザーの登録に成功しました")
            return "login"
        }else{
            log.error("ユーザーの登録に失敗しました")
            return "signup"
        }
    }

    /**
     * ログアウト処理
     */
    @GetMapping("/logout")
    fun logout(): String {
        return "login"
    }

}