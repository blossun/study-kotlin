package com.lannstark.lec12.kotlin

import com.lannstark.lec12.Movable

fun main() {
    //익명클래스 사용
    moveSomething(object : Movable {
        override fun move() {
            println("무브 무브")
        }

        override fun fly() {
            println("날다 날다")
        }
    })
}

private fun moveSomething(movable: Movable) {
    movable.move()
    movable.fly()
}
