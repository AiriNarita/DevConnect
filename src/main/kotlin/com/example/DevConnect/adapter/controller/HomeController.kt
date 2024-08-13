package com.example.DevConnect.adapter.controller

import org.springframework.stereotype.Controller
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
    fun index(): String {
        return "index"
    }
}