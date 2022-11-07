package com.lannstark.lec09

import java.lang.IllegalArgumentException

class Person(
    //부생성자보다는 default parameter를 권장!!!!!!!!!!
    name: String = "HoHoHo",
    var age: Int = 2 //val, var을 붙이면 자동으로 getter, setter를 만들어준다.
) {
    //3. 커스텀 getter를 만들어보자 //4. backing field
    //name을 get할때 무조건 대문자로 바꿔주자
    //name을 set할때 무조건 대문자로 바꿔주자
    var name = name //setter로 값을 변경할 수 있으려면 var로
        get() = field.uppercase() //field라는 백킹필드를 사용해야 한다.
        set(value) {
            field = value.uppercase()
        }

    //보통 다음과 같이 처리해서 사용한다.
    val upperCaseName: String
        get() = this.name.uppercase()

    //클래스가 생성되는 시점에 나이를 검증
    //init (초기화) 블록은 생성자가 호출되는 시점에 호출된다.
    init {
        if (age <= 0) {
            throw IllegalArgumentException("나이는 ${age}일 수 없습니다.")
        }
        println("주생성자")
    }

    //최초로 태어나는 아기는 무조건 1살이니, 생성자를 하나 더 만들자!
    //보조 생성자 - constructor 키워드로 추가해준다.
    constructor(name: String) : this(name, 1) {//this로 다른 생성자를 호출해줘야한다.
        println("보조생성자1")
    }

    //최종적으로 주생성자를 this로 호출해야 한다.
    //본문(body)는 역순으로 실행된다
    constructor() : this("Solar") { //이 보조 생성자를 사용한다면, 호출 순서는 아래에서 윗 순서
        println("보조생성자2")
    }

    //Converting과 같은 경우 부생성자를 사용할 수 있지만, 그보다는 정적 팩토리 메소드를 추천!!!!!!

    //3. 커스텀 getter, setter
    // 마치 Person 클래스에 프로퍼티가 있는 것처럼 보여줄 수 있다.
    //성인인지 확인하는 기능을 추가
    val isAdult: Boolean
        get() = this.age >= 20 //아래 블록과 동일. Expression으로 표현
//        get() {
//            return this.age >= 20
//        }
}

fun main() {
    // .필드를 통해 getter와 setter를 바로 호출한다
    val person = Person("Solar", 100)
    println(person.name)
    person.age = 200
    println(person.age)

    // Java 클래스에 대해서도 .필드로 getter, setter를 사용한다.
    val javaPerson = JavaPerson("JavaSolar", 1)
    println(javaPerson.name)
    javaPerson.age = 2
    println(javaPerson.age)

//    val peeerson = Person("Holar", -1) //ERROR - IllegalArgumentException: 나이는 -1일 수 없습니다.

    val kolar = Person("Kolar!!")
    println("name is ${kolar.name}, age is ${kolar.age}") //name is Kolar!!, age is 1

    println("생성자 호출 및 본문 순서 확인==============")
    val defaultPerson = Person() //본문(body)는 역순으로 실행된다. 생성자가 호출돼서 객체가 만들어진 이후에 println이 찍히는듯
    println("name is ${defaultPerson.name}, age is ${defaultPerson.age}") //name is Kolar!!, age is 1
}
