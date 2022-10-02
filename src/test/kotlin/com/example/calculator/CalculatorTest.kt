package com.example.calculator

import org.junit.jupiter.api.Test

class CalculatorTest {
    @Test
    fun `test if 2 + 4 is equal 6`() {
        val result = Calculator().add(2, 4)
        println("2 + 4 = $result")
        assert(result == 6L)
    }
}