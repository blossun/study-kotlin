/**
 * 레시피 2.2 자바에 널 허용성 지시자 추가하기
 * 문제
 *  - 코틀린 코드가 자바 코드와 상호 작용이 필요하고 널 허용성(nullability) 애노테이션을 강제하고 싶다.
 * 해법
 *  - 코틀린 코드에 JSR-305 널 허용성 애노테이션을 강제하려면 컴파일 타임 파라미터 Xjsr305=strict를 사용한다.
 */

fun main() {
    nullability();
}

/**
 * 코틀린 주요 기능
 * - 컴파일 시간에 타입 시스템에 널 허용성을 강제한다.
 */
fun nullability() {
    var s: String = "Hello" //널이 될 수 없거나 컴파일되지 않는다.
    var t: String? = null //타입에 있는 물음표는 널 허용 타입을 나타낸다.
    println("s => ${s}")
    println("t => ${t}")
}
