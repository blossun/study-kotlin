package com.lannstark.lec10.kotlin

interface Swimmable {
    //Kotlin에서는 backing field가 없는 프로퍼티를 Interface에 만들 수 있다
    //이 프로퍼티는 Swimmable에 field가 있는게 아니라
    //getter(val이니까)에 대한 것을 하위에서 구현해주는 것을 기대하는 것이다.
    //그렇기 때문에 인터페이스에서 자유롭게 swimAbility를 사용할 수 있다.
    val swimAbility: Int

    val swimYear: Int
        get() = 3 //직접 default 값을 넣어줄 수도 있다.
    //getter에 대한 default 메소드나 getter에 대한 추상 메소드를 인터페이스에 만드는 거라 backing field 없는 프로퍼티를 인터페이스에 만들 수 있다.

    fun act() {
        println("swimAbility is ${swimAbility}")
        println("swimYear is ${swimYear}")
        println("어푸 어푸")
    }
}
