package cookbook.ch02;

/**
 * 레시피 2.5 다른 기수로 출력하기
 * 문제
 *  - 십진법이 아닌 다른 기수를 사용하는 숫자를 출력하고 싶다.
 * 해법
 *  - 올바른 기수를 위해 확장 함수 toString(radix: Int)를 사용
 *
 * 자바의 정적 메소드를 사용해 Byte, Short, Int, Long에 확장 함수 toString(radix: Int)를 만들어 놓았다.
 */

fun main() {
    //42를 이진법으로 출력
    println("42의 이진 문자열 => ${42.toString(2)}") //101010

    //42를 적합한 모든 기수로 출력
    (Character.MIN_RADIX..Character.MAX_RADIX).forEach { radix ->
        println("${radix}: ${42.toString(radix)}")
    }
}
