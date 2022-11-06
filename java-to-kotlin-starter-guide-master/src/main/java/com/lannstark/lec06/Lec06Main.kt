package com.lannstark.lec06

fun main() {
    //1.
    val numbers = listOf(1L, 2L, 3L)
    for (number in numbers) {
        println(number)
    }

    //2-(1)
    for (i in 1..5 step 2) {
        println(i)
    }

    //2-(2)
    for (i in 3 downTo 1) {
        println(i)
    }

    //3. while 문은 자바와 동일
    var i = 1
    while (i <= 3) {
        println(i)
        i++
    }
}
