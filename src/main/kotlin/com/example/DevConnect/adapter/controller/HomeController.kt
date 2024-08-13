package com.example.DevConnect.adapter.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/")
class HomeController {
    @GetMapping
    fun index(): String {
        return "index" // index.htmlを表示
    }
}