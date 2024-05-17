package com.crossoid.bigdecimal_example

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform