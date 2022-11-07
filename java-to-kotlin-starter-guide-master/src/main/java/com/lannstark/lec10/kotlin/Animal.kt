package com.lannstark.lec10.kotlin

abstract class Animal(
    protected val species: String,
    protected open val legCount: Int //open 해줘야 하위 클래스에서 override가 가능하다.
) {
    abstract fun move()// return type Unit은 생략가능
}
