package com.lannstark.lec12.kotlin

fun main() {
    println(Person.newBaby("Solar")) //사용법은 Java와 동일

    //싱글톤 접근 - 바로 이름으로 접근하면 된다.
    println(Singleton.a) //0
    Singleton.a += 10
    println(Singleton.a) //10
}

data class Person private constructor(
    val name: String,
    val age: Int
) {

    // 코틀린에는 static이 없다.
    // companion object(동행 객체)를 이용해야 한다.
    companion object Factory : Log { //이름을 붙일 수도 있다. (자바와 다른점)
        private const val MIN_AGE = 1 //const 키워드의 의미?

        @JvmStatic
        fun newBaby(name: String): Person {
            return Person(name, MIN_AGE)
        }

        override fun long() {
            println("나는 Person 클래스의 동행객체 Factory 입니다.")
        }
    }
}

/**
 * const 의 의미
그냥 val 이라고 쓰면 MIN_AGE라는 변수에 0이라는 값이 런타임시에 할당이 된다. 그런데 앞에 const를 붙이게 되면 컴파일시에 변수가 할당된다.
런타임시에 할당되냐 컴파일 시에 할당 되냐… 그래서 차이가 있다.
그래서 이 const 라는 건 진짜 상수(const)에 붙이기위한 용도이다.
기본 타입과 String에만 붙일 수 있다.

Java와 다른 점 한 가지!
- companion object, 즉 동반객체도 하나의 객체로 간주된다. 때문에 이름을 붙일 수도 있고, interface를 구현할 수도 있다.

 */

//싱글톤
object Singleton {
    var a: Int = 0
}
