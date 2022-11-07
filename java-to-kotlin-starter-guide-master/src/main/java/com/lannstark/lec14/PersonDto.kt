package com.lannstark.lec14

fun main() {
    val personDto01 = PersonDto("Solar", 100)
    val personDto02 = PersonDto("Solar", 100)
    println(personDto01 == personDto02) //true
    println(personDto01) //PersonDto(name=Solar, age=100)
}
data class PersonDto(
    private val name: String,
    private val age: Int
) {
}
