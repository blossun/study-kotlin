package com.lannstark.lec16

//멤버함수와 시그니처가 같은 확장함수
fun Person.nextYearAge(): Int {
    println("확장 함수")
    return this.age + 1
}

fun main() {
    val person = Person("A", "B", 100)
    person.nextYearAge() // 확장함수 vs 멤버함수 어떤것이 호출될까? -> 멤버 함수!!
}
