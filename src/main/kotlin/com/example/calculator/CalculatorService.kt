package com.example.calculator

import org.springframework.stereotype.Service

@Service
class CalculatorService {
    fun add(a: Long, b: Long): Long = a + b
}