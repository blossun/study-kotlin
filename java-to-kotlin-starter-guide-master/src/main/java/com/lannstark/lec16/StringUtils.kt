package com.lannstark.lec16

fun main() {

    //확장함수 사용
    val str = "ABC"
    println(str.lastChar()) //C
}

/**
 * String 클래스 안에 있는 것 같은 확장함수를 하나 만들어 보자.
 *  - 기능 : 문자열의 가장 끝에 있는 문자를 가져오기
 *
 * fun 확장하려는클래스.함수이름(파라미터): 리턴타입 {
 *   // this를 이용해 실제 클래스 안의 값에 접근
 * }
 */
fun String.lastChar(): Char { //
    // String을 통해서 함수가 불러 졌을 때,
    // 본인 자신에게 있는 마지막 문자를 가져와야 한다.
    // this(수신객체) - 함수가 불려진 instance를 가져온다.
    return this[this.length - 1]
}

// 확장함수 라는 개념은 확장프로퍼티와도 연결된다.
// 확장 프로퍼티의 원리는 확장함수 + custom getter와 동일하다!
val String.firstChar: Char
    get() = this[0]
