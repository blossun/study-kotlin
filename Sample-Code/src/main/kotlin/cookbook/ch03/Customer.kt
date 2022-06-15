package cookbook.ch03

/**
 * 3.7 equals 재정의를 위해 안전 타입 변환, 레퍼런스 동등, 엘비스 사용하기
 * 문제
 *  - equals 구현
 * 해법
 *  -
 */
class Customer(val name: String) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        val otherCustomer = (other as? Customer) ?: return false
        return this.name == otherCustomer.name
    }

    override fun hashCode() = name.hashCode()
}

fun main() {
    val customer1 = Customer("Solar")
    val customer2 = Customer("Solar")

    println("${customer1.equals(customer2)}") //true
    println("c1 hashCode : ${customer1.hashCode()}, c2 hashCode : ${customer2.hashCode()}")
}
