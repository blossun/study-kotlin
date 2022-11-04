package com.lannstark.lec01

fun main() {
    var number1 = 10L // (1) 가변, 타입추론
    val number2: Long = 10L // (2) 불변, 타입 명시
    //코드상에서는 primitive와 referce 타입을 구분하지 않는다.
    //숫자, 문자, 불리언같은 몇몇 타입은 실행시에 Primitive Value로 표현된다. //이 코드를 자바코드로 바꿔보면 long으로 실행되는 것을 확인할 수 있다.

    //초기값을 지정해주지 않는 경우
    var numberX: Long //타입추론이 불가능하기 떄문에 타입 명시가 필수
    numberX = 5
    println("number3 is $numberX") //초기화되지 않고 사용하려면 에러발생

    var number3: Long? = 1000L // (3) nullable하게 만드려면 타입 뒤에 ?를 붙여야한다.
    var person = Person("최태현") // (4)
}
