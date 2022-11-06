package com.lannstark.lec05

import java.lang.IllegalArgumentException

fun main() {
//    validateScoreIsNotNegative(-1)
    println(getPassOrFail(51)) //P
    println(isIn0to100(50)) //true
    println(isIn0to100(600)) //false
    println(isIn0to100(200)) //false

    println(getGradeWithWhen(50)) //D
}

fun validateScoreIsNotNegative(score: Int): Unit { //Unit은 void를 의미
    if (score < 0) {
        throw IllegalArgumentException("${score}는 0보다 작을 수 없습니다.")
    }
}

fun getPassOrFail(score: Int): String {
    return if (score >= 50) {
        "P"
    } else {
        "F"
    }
}

//어떠한 값이 특정 범위에 포함되어 있는지, 포함되어 있지 않은지
fun isIn0to100(score: Int): Boolean {
    return if (score in 0..100) { //범위에 포함되었는지 확인
        println("${score}가 0과 100사이에 있습니다.")
        true
    } else if (score !in 0..500) { //범위에 포함되지 않았는지 확인
        println("${score}는 비교가능 범위를 넘었습니다.")
        false
    } else {
        println("${score}는 0과 100사이에 없습니다.")
        false
    }
}

//switch가 사라지고 when을 사용한다.
//when도 expression 이다.
fun getGradeWithWhen(score: Int): String {
    return when (score / 10) {
        9 -> "A"
        8 -> "B"
        7 -> "C"
        else -> "D"
    }
}

//조건부에는 어떤한 expression도 들어갈 수 있다.
fun getGradeWithWhenV2(score: Int): String {
    return when (score) {
        in 90..99 -> "A"
        in 80..89 -> "B"
        in 70..79 -> "C"
        else -> "D"
    }
}

// is Type 조건문과 스마트 캐스트
fun startsWithA(obj: Any): Boolean {
    return when (obj) {
        is String -> obj.startsWith("A") //스마트 캐스트
        else -> false //expression으로 쓰였기 때문에 else가 필수이다.
    }
}

//여러개의 조건을 동시에 검사할 수 있다. (콤마,로 구분)
fun judgeNumber(number: Int): Unit {
    when (number) {
        1, 0, -1 -> println("어디서 많이 봄")
        else -> println("낯서네요") //expression으로 쓰인게 아니니깐 else가 필수는 아니다.
    }
}

// when(값)에서 (값)이 없을 수도 있다. early return 처럼 동작
fun judgeNumber2(number: Int) {
    when {
        number == 0 -> println("주어진 숫자는 0입니다.")
        number % 2 == 0 -> println("주어진 숫자는 짝수입니다.")
        else -> println("주어진 숫자는 홀수 입니다.")
    }
}
