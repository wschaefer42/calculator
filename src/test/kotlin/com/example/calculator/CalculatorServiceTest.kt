package com.example.calculator

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class CalculatorServiceTest {
    @Autowired
    private lateinit var calculatorService: CalculatorService

    @Test
    fun `test sum of two values`() {
        assert(calculatorService.add(2, 3) == 5L)
    }
}