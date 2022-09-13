package com.example.calculator

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class CalculatorResource(val service: CalculatorService) {
    @GetMapping("/add")
    fun add(@RequestParam a: Int, @RequestParam b: Int) = service.add(a, b)
}