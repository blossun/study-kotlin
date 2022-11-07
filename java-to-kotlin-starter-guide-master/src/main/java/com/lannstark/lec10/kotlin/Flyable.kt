package com.lannstark.lec10.kotlin

interface Flyable {
    fun act() { //default 키워드를 쓰지 않았도 default함수가 된다.
        println("파닥 파닥")
    }

    fun fly() //추상 메서드
}
