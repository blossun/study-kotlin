package com.lannstark.lec16

// 확장함수
fun Int.add(other: Int): Int {
    return this + other
}

// 중위함수
infix fun Int.add2(other: Int): Int {
    return this + other
}

// inline함수
inline fun Int.add3(other: Int): Int {
    return this + other
}


fun main() {
    println(3.add(4))

    println(3.add2(4))
    println(3 add2 4) //중위함수는 "변수 함수이름 argument" 형태로도 호출할 수 있는 새로운 함수 호출 방법이다.

    println(3.add3(4)) //바이트코드를 확인해보면, 함수를 호출하는게 아니라 덧셈하는 로직 자체가 함수를 부르는 쪽에 복사 붙여넣기 되어있다.
}
