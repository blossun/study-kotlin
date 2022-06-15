package cookbook.ch03

/**
 * 3.3 데이터 클래스 정의하기
 * 문제
 *  - equals, hashCode, toString 등이 완벽하게 갖춰진 엔티티를 나타내는 클래스를 생성하고 싶다.
 * 해법
 *  - 클래스를 정의할 때 data 키워드를 사용
 */

data class Product( // {} 아니고 ()
    val name: String,
    var price: Double,
    var onSale: Boolean = false
)

fun main() {
    val product1 = Product("swim", 0.5, false)
    val product2 = Product("swim", 0.5)

    println("p1 == p2 ? ${product1 == product2}") //true
    println("p1.hashCode() == p2.hashCode() ? ${product1.hashCode() == product2.hashCode()}") //true

    // 구조분해
    val (name, price, onSale) = product1
    println("name : ${name}, price : ${price}, onSale : ${onSale}") //name : swim, price : 0.5, onSale : false
}
