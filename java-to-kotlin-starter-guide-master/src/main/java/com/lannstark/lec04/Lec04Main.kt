package com.lannstark.lec04

fun main() {
    //객체 비교 시, 비교 연산자를 사용하면 자동으로 compareTo를 호출해준다.
    val money1 = JavaMoney(2_000L)
    val money2 = JavaMoney(1_000L)
    if (money1 > money2) { //true // > 연산자를 누르면 compareTo로 이동한다.
        println("money1이 money2보다 금액이 큽니다.")
    }

    //동등성, 동일성비교
    val money3 = money1
    val money4 = JavaMoney(2_000L)
    //동일성(주소) 비교
    println(money1 === money3) //true
    println(money1 === money4) //false
    //동등성(값) 비교 - java의 equals()
    println(money1 == money3) //true
    println(money1 == money4) //true

    //연산자 오버로딩
    val kMoney1 = Money(3_000L)
    val kMoney2 = Money(4_000L)
    println(kMoney1 + kMoney2) //7000 // + 연산자를 이용해서 plus를 할 수 있다.
}
