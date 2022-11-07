package com.lannstark.lec14

fun handleCountry(country: Country) {
    when (country) {
        Country.KOREA -> TODO()
    }
}

enum class Country(
    private val code: String //프로퍼티 선언. 코틀린은 프로퍼티를 생성자와 함께 바로 만든다.
) {

    KOREA("KO"),
    AMERICA("US")
    ;
}

/** ENUM
 - kotlin의 ENUM 구현 딱히 Java와 다른게 없다. 그런데..
 - "when은 Enum Class 혹은 Sealed Class와 함께 사용할 경우, 더욱더 진가를 발휘한다."
 - 컴파일러가 ENUM의 모든 타입을 알고 있기 때문에 when에서 Enum을 소괄호로 값을 받을 때는 다른 타입에 대한 로직(else)을 작성하지 않아도 된다.
 - Enum에 변화가 있으면 알 수 있다.
 - Enum에 추가된 값이 있으면 when 코드에서 “Enum에 추가된 코드가 있는데 when Expression에는 그 Enum값을 추가하지 않았어!!”라고 warning을 준다. (ide 설정에 따라서 warning이 아니라 error를 주도록 변경 가능)
- when expression을 return하는 경우에는 모든 enum에 대한 조건 분기 처리를 해야한다. 특정 enum이 빠지면 IDE가 알려준다.
*/

/**
 * Sealed Class, Sealed Interface
 - 컴파일 타임 때 하위 클래스의 타입을 모두 기억한다. 즉, 런타임때 클래스 타입이 추가될 수 없다.
 - 하위 클래스는 같은 패키지에 있어야 한다.
 - Enum과 다른 점
     - 클래스를 상속받을 수 있다.
     - 하위 클래스는 멀티 인스턴스가 가능하다.
 - Sealed Class 역시 when과 함께 주로 사용되면서 Enum과 같은 장점을 얻을 수 있다.
 - 추상화가 필요한 Entity or DTO에 sealed class를 활용
 */
