package com.example.DevConnect.adapter.controller

import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

/**
 * HomeController ホームコントローラ
 */
@Controller
@RequestMapping("/")
class HomeController {
    /**
     * ホームページの表示
     */
    @GetMapping
    fun index(model: Model): String {
        val authentication: Authentication? = SecurityContextHolder.getContext().authentication
        val isLoggedIn = authentication?.isAuthenticated == true && authentication?.name != "anonymousUser"
        model.addAttribute("isLoggedIn", isLoggedIn)
        println("$isLoggedIn")
        return "index"
    }

}