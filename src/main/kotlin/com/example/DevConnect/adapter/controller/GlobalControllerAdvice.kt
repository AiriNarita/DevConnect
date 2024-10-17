package com.example.DevConnect.adapter.controller

import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ModelAttribute

/**
 * GlobalControllerAdvice グローバルコントローラーアドバイス
 * @property model Model
 */
@ControllerAdvice
class GlobalControllerAdvice {
    /**
     * ログイン状態を追加
     * @param model Model
     */
    @ModelAttribute
    fun addAttributes(model: Model) {
        val authentication = SecurityContextHolder.getContext().authentication
        val isLoggedIn = authentication != null && authentication.isAuthenticated && authentication.principal != "anonymousUser"
        model.addAttribute("isLoggedIn", isLoggedIn)
    }
}