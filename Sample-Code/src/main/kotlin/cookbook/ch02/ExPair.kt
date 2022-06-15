package cookbook.ch02

/**
 * 레시피 2.9 to로 Pair 인스턴스 생성하기
 * 문제
 *  - (보통 맵의 항목으로서) Pair 클래스의 인스턴스를 생성하고 싶다.
 * 해법
 *  - 직접 Pair 클래스의 인스턴스를 생성하기 보다는 중위(infix) to 함수를 사용한다.
 */

fun main() {
    //mapOf의 인자인 pair를 생성하기 위해 to 함수 사용하기
    val map = mapOf("name" to "solar", "age" to 3)
    println("name : ${map["name"]}") //solar
    println("age : ${map["age"]}") //30

    val p1 = Pair("you", "tube")
    val p2 = "Intelli" to "J"
    println("p1.first => ${p1.first}") // you
    println("p1.second => ${p1.second}") // tube
    println("p2.first => ${p2.first}") //Intelli
    println("p2.second => ${p2.second}") //J

    val p3 = Pair("Intelli", "J")
    println("p3 equalTo p2 ? ${p3.equals(p2)}") //true
    println("p3 == p2 ? ${p3 == p2}") //true
}
