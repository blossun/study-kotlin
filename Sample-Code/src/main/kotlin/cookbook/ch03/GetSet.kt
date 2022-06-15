package cookbook.ch03

/**
 * 3.2 사용자 정의 획득자와 설정자 생성하기
 * 문제
 *  - 값을 할당하거나 리턴하는 방법을 사용자 정의하고 싶다.
 * 해법
 *  - 코틀린 클래스의 속성에 get과 set 함수를 추가한다.
 *
 * - 코틀린은 모든 것이 기본적으로 public이다.
 * - 코틀린 클래스에서 필드는 직접 선언할 수 없다.
 */

/**
 * 최상위 멤버로 선언한 priority
 *  - 단점 : apply 블록을 사용해서 priority에 값을 할당할 수 있지만, 클래스를 인스턴스화할 때 priority에 값을 할당할 수 없다.
 *  - 장점 : 쉽게 사용자 정의 획득자와 설정자를 추가할 수 있따.
 */
class GetSet(val name: String) { //주 생성자 안에 선언
    var priority = 3 //최상위 멤버
        set(value) { // priority 속성의 사용자 정의 설정자
            field = value.coerceIn(1..5) //field 식별자는 오직 사용자 정의 획득자나 설정자에서만 사용할 수 있다.
        }

    // 파생 속성을 위한 사용자 정의 획득자
    val isLowPriority
        get() = priority < 3
}

fun main() {
    val myTask = GetSet("solar").apply { priority = 4 }
    println("myTask : ${myTask.name}, ${myTask.priority}") //myTask : solar, 4

    println("myTask.isLowPriority ? ${myTask.isLowPriority}") //false

    myTask.priority = 2;
    println("myTask priority : ${myTask.priority}") //2
}
