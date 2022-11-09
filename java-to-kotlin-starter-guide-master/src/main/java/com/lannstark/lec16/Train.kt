package com.lannstark.lec16

open class Train(
    val name: String = "새마을 기차",
    val price: Int = 5_000,
)

fun Train.isExpensive(): Boolean {
    println("Train의 확장함수")
    return this.price >= 10_000
}

class Srt : Train("SRT", 40_000)

// 장함수가 오버라이드 된다면?!!
fun Srt.isExpensive(): Boolean {
    println("Srt의 확장함수")
    return this.price >= 10_000
}

fun main() {
    val train: Train = Train()
    train.isExpensive() //Train의 확장함수

    val srt1: Train = Srt()
    srt1.isExpensive() //Train의 확장함수

    val srt2: Srt = Srt()
    srt2.isExpensive() //Srt의 확장함수

    // 결론. 해당 변수의 현재 타입즉, 정적인 타입에 의해 어떤 확장함수가 호출될지 결정된다.
}

/**
 * 확장함수 특징
 * 1. 확장함수는 원본 클래스의 private, protected 멤버 접근이 안된다!
 * 2. 멤버함수, 확장함수 중 멤버함수에 우선권이 있다!
 * 3. 확장함수는 현재 타입을 기준으로 호출된다!
 * 4. Java에서 Kotlin 확장함수를 정적 메소드를 부르는 것처럼 사용 가능하다.
 */
