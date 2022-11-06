package com.lannstark.lec04

data class Money(
    val amount: Long
) {
    //연산자 오버로딩
    operator fun plus(other: Money): Money {
        return Money(this.amount + other.amount)
    }
}
