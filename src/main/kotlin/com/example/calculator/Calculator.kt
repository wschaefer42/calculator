package com.example.calculator

class Calculator {
    var first: Long = 0
        private set
    var second: Long = 0
        private set
    var result: Long = 0
        private set
    fun add(first: Long, second: Long): Long {
        this.first = first
        this.second = second
        this.result = first + second
        return result
    }
}