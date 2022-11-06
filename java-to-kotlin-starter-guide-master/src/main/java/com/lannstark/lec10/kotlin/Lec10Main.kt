package com.lannstark.lec10.kotlin

fun main() {
    Derived(300)
}

open class Base( //open 해줘야 상속받을 수 있다.
    open val number: Int = 100
) {
    init {
        println("Base Class")
        println(number) //Accessing non-final property number in constructor. 경고문을 주고 있다.
    }
}

class Derived(
    override val number: Int
) : Base(number) {
    init {
        println("Dervied Class")
    }
}
//Derived를 인스턴화하면 어떻게 될까?
//초기화 블록이 어떤 순서로 실행되고 이 number값에는 무엇이 들어갈까?
//==실행결과==
//Base Class
//0
//Dervied Class

//왜 이런 결과가 나올까?
//Accessing non-final property number in constructor
// 상위 클래스 생성자가 실행되는 동안, 하위 클래스의 프로퍼티 즉 이 Derived를 인스턴스화 한다는 말은
// Derived에 있는 number에 값을 집어 넣어준다는 것인데
// 이 떄 상위 클래스에서 넘버를 호출하게 되면 하위 클래스의 넘버를 가져오게 된다.
// 그런데 아직 상위 클래스의 constructor가 먼저 실행된 단계라서
// 하위 클래스에 number라는 값에 초기화가 이루어지지 않은 것이다.
// 그 상태에서 먼저 하위 클래스의 number에 접근하니까 int 기본값인 0이 나오게 된다.

// 결론.
// "상위 클래스에 constructor 및 init 블록에서는 하위 클래스의 field에 접근하면 안된다"라고 얘기하고 있느 것이다.
// 정확히는 final이 아닌 (하위 클래스에서 override하고 있는) 프로퍼티에 접근하면 안 된다. (final은 어짜피 상관없으니까)
