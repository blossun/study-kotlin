package cookbook.ch03

/**
 * 3.1 const와 val 차이 이해하기
 * 문제
 *  - 런타임보다는 컴파일 타임에 변수가 상수임을 나타내야한다.
 * 해법
 *  - 컴파일 타임 상수에 const 변경자를 사용한다.
 *    val 키워드는 한 번 할당되면 변경이 불가능함을 나타내지만 이러한 할당은 실행 시간에 일어난다.
 *
 * 컴파일 타임 상수 특징
 *  - 반드시 객체나 동반 객체 선언의 최상위 속성 또는 멤버여야 한다.
 *  - 문자열 또는 기본 타입의 래퍼 클래스이며, 사용자 정의 획득자(getter)를 가질 수 없다.
 *  - 컴파일 시점에 값을 사용할 수 있도록 main 함수를 포함한 모든 함수의 바깥쪽에서 할당돼야 한다.
 */

class ConstVal(val name: String, _priority: Int = DEFAULT_PRIORITY) {

    companion object {
        const val MIN_PRIORITY = 1
        const val MAX_PRIORITY = 5
        const val DEFAULT_PRIORITY = 3
    }

    var priority = validPriority(_priority)
        set(value) {
            field = validPriority(value)
        }

    private fun validPriority(_priority: Int) =
        _priority.coerceIn(MIN_PRIORITY, MAX_PRIORITY)
}

fun main() {
    val constVal = ConstVal("solar");
    println("constVal name : ${constVal.name}, priority : ${constVal.priority}")
}
