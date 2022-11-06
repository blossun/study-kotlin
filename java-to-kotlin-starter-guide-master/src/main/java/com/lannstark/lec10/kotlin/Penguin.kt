package com.lannstark.lec10.kotlin

class Penguin(
    species: String,
) : Animal(species, 2), Flyable, Swimmable {
    private val wingCount: Int = 2

    override fun move() {
        println("펭귄이 움직입니다. 펭펭!!")
    }

    override val legCount: Int //Animal의 legCount가 open이어야 override할 수 있다.
        get() = super.legCount + this.wingCount

    override fun act() {
        super<Swimmable>.act() //특정 상위 인터페이스의 함수를 override할 때 문법의 차이
        super<Flyable>.act()
    }

    override fun fly() {
        println("날아~~~~~~~~~~")
    }

    override val swimAbility: Int
        get() = 3

    override val swimYear: Int
        get() = 5
}
