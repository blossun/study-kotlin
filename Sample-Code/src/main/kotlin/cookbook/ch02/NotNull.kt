/**
 * 레시피 2.1  코틀린에서 널 허용 타입 사용하기
 * 문제
 *  - 변수가 절대 null값을 갖지 못하게 하고 싶다.
 *
 * 해법
 *  - 물음표를 사용하지 않고 변수의 타입을 정의한다.
 *  - 널 허용 타입은 안전 호출 연산자(?.)나 엘비스 연산자(?:)와 결합해서 사용한다.
 */

fun main() {
    var name: String //null을 넣을 수 없는 타입
    name = "Solar"
//    name = null //null을 넣을 수 없다.
    println("name is ${name}")

    nullable()
    smartCast()
    safeCall()
    safeCallWithElvis()
    safeCast()
}

/**
 * null을 허용하려면 타입 정의에 물음표를 추가
 */
data class Person(
    val first: String,
    val middle: String?,
    val last: String
) //data 클래스로 만들면 자동으로 toString을 만들어줌

fun nullable() {
    val solar = Person("Solar", null, "Kim") //객체 생성 시 new 키워드 X
    println("nullable : solar => $solar")
}

/**
 * null 허용 변수를 식(expression)에서 사용
 * 널 할당이 불가능한 문자열 타입으로 영리한 타입 변환(smart cast)을 수행
 */
fun smartCast() {
    val p = Person(first = "Solar", middle = "kiki", last = "Kim") //smart cast는 val 키워드(immutable)로 선언되었기 때문이다. var 키워드(mutable)로 선언하면 불가능
    if (p.middle != null) {
        val middleNameLength = p.middle.length //smart cast => p.middle의 타입이 'String?' 에서 'String'으로 자동 변환
        println("smart cast : middleNameLength => ${middleNameLength}")
    }

    var p2 = Person(first = "Solar", middle = "kiki", last = "Kim") //var로 선언
    if (p2.middle != null) {
//        val middleNameLength = p2.middle.length //smart cast 불가능. p2가 var이기 때문에
        val middleNameLength = p2.middle!!.length // `ii` 키워드 : 널 아님을 단언(assert)을 사용해서 변환 (사용하지 말 것. 안전호출 연산자(safe call) ?: 를 사용하자)
        println("assert : middleNameLength => ${middleNameLength}")
    }
}

/**
 * 안전 호출(safe call) 연산자
 * ?:
 * 쇼트  서킷 평가 방식
 * 값이 널이면 null을 반환
 * 예제의 safe call 결과 타입은 `Int?` 이다.
 */
fun safeCall() {
    val p = Person(first = "Solar", middle = "kiki", last = "Kim")
    val middleNameLength = p.middle?.length //safe call 결과 타입은 `Int?` 이다.
    println("safe call (not null) : middleNameLength => ${middleNameLength}")

    val p2 = Person(first = "Solar", middle = null, last = "Kim")
    val middleNameLength2 = p2.middle?.length //safe call 결과 타입은 `Int?` 이다.
    println("safe call (null) : middleNameLength => ${middleNameLength2}") //null이 출력
}

/**
 * 안전 호출(safe call) 연산자와 엘비스(Elvis) 연산자
 * ?. ?:
 * 위 예제 safe call의 반환 타입이 `Int?` (nullable) 타입이므로 엘비스 연산자와 병행해서 사용하는 것이 유용하다.
 * 엘비스 연산자
 *  - 왼쪽 식의 값을 확인해서 해당 값이
 *      널이 아니면 그 값을 리턴
 *      널 이면 오른쪽 값을 리턴
 */
fun safeCallWithElvis() {
    val p = Person(first = "Solar", middle = null, last = "Kim")
    val middleNameLength = p.middle?.length ?: 0 //결과 타입은 `Int` 이다.
    println("safe call with Elvis : middleNameLength => ${middleNameLength}")
}

/**
 * 안전 타입 변환(safe cast) 연산자
 * as?
 * 목적
 *      타입 변환이 올바르게 동작하지 않는 경우 ClassCastException이 발생하는 상황을 방지한다.
 * 예제
 *      어떤 인스턴스를 Animal 타입으로 변환을 시도했지만 해당 인스턴스가 널일 수도 있는 상황이라면 다음과 같이 작성해서
 *      타입 변환이 성공하면, 그 결과 Animal 타입이 되든가
 *      실패하여, null값을 받는다. (Exception 발생을 방지)
 */
data class Animal(
    val type: String,
    val age: Int
)

fun safeCast() {
    val p = Person(first = "Solar", middle = null, last = "Kim")
    val p1 = p as? Animal //p1의 타입은 `Animal?` 이다.
    println("safe cast : p1 is ${p1}") //null
}
