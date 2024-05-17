package com.crossoid.bigdecimal_example

import java.math.BigDecimal

class Greeting {
    private val platform: Platform = getPlatform()

    fun greet(): String {
        val first = BigDecimal("5")
        val second = BigDecimal("8")
        val result = "I can count with BigDecimal: $first * $second = ${first*second}"

        return "Hello, ${platform.name}!\n$result"
    }
}