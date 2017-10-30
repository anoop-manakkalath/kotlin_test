package com.kotlin.basic.test

fun main(args: Array<String>) {
    println("Hello, World!")

    val mul3 = makeMathFun(3)
    println("5 * 3 = ${mul3(5)}")

    val mul2 = { n:Int -> n * 2 }
    val numList = arrayOf<Int>(1, 2, 3, 4)
    mathOnList(numList, mul2)
}

fun makeMathFun(num1: Int): (Int) -> Int = {num2 -> num1 * num2}

fun mathOnList(numList: Array<Int>, myFun: (n: Int) -> Int) {
    for (num in numList) {
        println("MathOnList ${myFun(num)}")
    }
}