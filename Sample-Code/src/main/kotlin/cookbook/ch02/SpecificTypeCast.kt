package cookbook.ch02

/**
 * 레시피 2.4 명시적으로 타입 변환하기
 * 문제
 *  - 코틀린은 자동으로 기본 타입을 더 넗은 타입으로 승격하지 않는다. ex) Int -> Long (X)
 * 해법
 *  - 더 작은 타입을 명시적으로 변환하려면 toInt, toLong 등 구체적인 변환 함수를 사용한다.
 *
 * 코틀린에서는 기본 타입을 직접적으로 제공하지 않는다.
 * 개발자가 코드를 직접 작성할 떄는 기본 타입이 아닌 클래스를 다뤄야 한다.
 */

fun main() {
    val intVar: Int = 3
//        val longVar: Long = intVar //error - 컴파일되지 않음
    val longVar: Long = intVar.toLong() //명시적 타입 변환

    // 타입 변환을 투명하게 수행하는 연산자 중복 장점이 있기 떄문에 아래 코드는 명시적 타입 변환이 필요하지 않다.
    val longSum = 3L + intVar
    println("longSum = ${longSum}")
}
