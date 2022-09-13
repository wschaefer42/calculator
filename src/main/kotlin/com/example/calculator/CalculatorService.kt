package com.example.calculator

import org.springframework.stereotype.Service

@Service
class CalculatorService {
    fun add(a: Int, b: Int): Int = a + b
}