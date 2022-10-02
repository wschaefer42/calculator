package com.example.calculator

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HealthResource {
    @GetMapping("/ping")
    fun ping() = "pong"
}