package com.example.calculator

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Scope

@SpringBootApplication
class CalculatorApplication {
	@Bean
	@Scope("singleton")
	fun calculatorSingleton(): Calculator = Calculator()

	companion object {
		const val invalidConst = "add"
	}
}

fun main(args: Array<String>) {
	runApplication<CalculatorApplication>(*args)
}
