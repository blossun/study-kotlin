package cookbook.ch02

import java.text.NumberFormat

/**
 * 레시피 2.3 자바를 위한 메서드 중복
 * 문제
 *  - 기본 파라미터를 가진 코틀린 함수가 있는데,
 *    자바에서 각 파라미터의 값을 직접적으로 명시하지 않고 해당 코틀린 함수를 호출하고 싶다.
 * 해법
 *  - @JvmOverloads 애노테이션을 해당 함수에 추가한다.
 */

/**
 * 기본 파라미터가 정의된 코틀린 함수
 */
@JvmOverloads //@JvmOverloads를 생략하면 java에서 addProduct 함수를 호출하려면 모든 인자를 제공해야 한다. @JvmOverloads를 추가하면 컴파일된 클래스는 모든 함수 중복을 지원한다.
fun addProduct(name: String, price: Double = 0.0, desc: String? = null) =
    "Adding product with $name, ${desc ?: "None"}, and " +
            NumberFormat.getCurrencyInstance().format(price)

/**
 * 생성자 중복
 * 아래 Product 클래스는 3개의 생성자를 제공한다.
 * 인자 종류
 * 1. name, price, desc
 * 2. name, price
 * 3. name
 */
data class Product @JvmOverloads constructor( //@JvmOverloads를 생략하면 java에서 생성자로 생성 시 모든 인자를 주어야한다.
    val name: String,
    val price: Double = 0.0,
    val desc: String? = null
)

