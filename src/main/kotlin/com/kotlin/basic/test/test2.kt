package com.kotlin.basic.test

import java.math.BigDecimal

var x  = 1L

var y = BigDecimal(x)

val z = 34L.bigdecimal

private val Long.bigdecimal: Any
    get() = BigDecimal(this)

fun main(args: Array<String>) {
    println("${y} and ${z}")
}
