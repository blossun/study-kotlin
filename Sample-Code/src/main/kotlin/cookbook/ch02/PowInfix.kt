package cookbook.ch02

import kotlin.math.pow

/**
 * 레시피 2.6 숫자를 거듭제곱하기
 * 문제
 *  - 미리 정의된 거듭제곱 연산자가 없다.
 * 해법
 *  - Int와 Long에 정의돼 있는 코틀린 확장 함수 pow에 위임하는 중위(infix) 함수를 정의
 *
 */
fun main() {
   // 직접 변환
    println("2의 8제곱(256) : ${2.toDouble().pow(8).toInt()}")
    println("2의 8제곱(256) : ${2 `**` 8}")
    println("2의 3제곱(8) : ${2F `**` 3}")

}

infix fun Int.`**`(x: Int) = toDouble().pow(x).toInt()
infix fun Long.`**`(x: Int) = toDouble().pow(x).toLong()
infix fun Float.`**`(x: Int) = pow(x)
infix fun Double.`**`(x: Int) = pow(x)

fun Int.pow(x: Int) = `**`(x)
fun Long.pow(x: Int) = `**`(x)

