package com.example.calculator

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class CalculatorResource(val service: CalculatorService) {
    @Autowired
    private lateinit var calculatorService: CalculatorService

    @GetMapping("/add")
    fun add(@RequestParam a: Long, @RequestParam b: Long) = service.add(a, b)
}