package com.example.calculator

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/calculate")
class CalculatorController {
    @Autowired
    private lateinit var calculator: Calculator

    @GetMapping
    fun index(model: Model): String {
        model["first"] = calculator.first
        model["second"] = calculator.second
        model["result"] = calculator.result
        return "calculate"
    }

    @PostMapping("/add")
    fun add(model: Model, first: String, second: String): String {
        calculator.add(first.toLong(), second.toLong())
        return "redirect:/calculate"
    }
}