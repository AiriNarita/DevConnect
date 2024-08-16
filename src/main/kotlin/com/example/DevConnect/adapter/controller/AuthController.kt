package com.example.DevConnect.adapter.controller

import OperationResult
import com.example.DevConnect.configration.logger
import com.example.DevConnect.infrastructure.dto.UserSignUpForm
import com.example.DevConnect.service.SignUpService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/")
class AuthController(
    private val userService: SignUpService,
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
     * @param userForm ユーザー登録フォーム
     * @param bindingResult バインディング結果
     */
    @PostMapping("/signup")
    fun signup(
        @ModelAttribute userForm: UserSignUpForm,
        bindingResult: BindingResult,
        model: Model
    ): String{
        val result = userService.createUser(userForm)
        return when (result)  {
            is OperationResult.Success -> {
                log.info("ユーザーの登録に成功しました")
                return "login"
            }
            is OperationResult.Failure -> {
                log.error("ユーザーの登録に失敗しました: ${result.error}")
                bindingResult.rejectValue("username", "error.userForm",  result.error)
                return "signup"
            }
            else -> {
                log.error("予期しないエラーが発生しました")
                "signup"
            }
        }
    }

}