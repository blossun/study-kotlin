package com.lannstark.lec15

fun main() {
    // 배열
    val array = arrayOf(100, 200)
    array.plus(300) //배열에 plus()를 통해서 값을 추가

    //방법1. 인덱스를 이용
    for (i in array.indices) {//array에 있는 개수를 세서 인덱스를 Range로 담아준다. -> //array.indices에서 반환하는 값 확인. IntRange(0, lastIndex)
        println("${i} ${array[i]}")
    }

    //방법2. index와 value를 한번에 받을 수 있다.
    for ((idx, value) in array.withIndex()) {
        println("${idx} ${value}")
    }

    // 컬렉션
    //1. List
//    val numbers = listOf(100, 200) //불변 리스트 //타입을 명시하지 않아도 값을 통해 타입 추론이 가능
    val numbers = mutableListOf(100, 200) //가변 리스트 - 기본 구현체는 ArrayList이고 기타 사용법은 Java와 동일
    numbers.add(300) //값 추가

    val emptyList = emptyList<String>() //emptyList를 만들 때는 리스트에 들어올 타입이 무엇인지를 명시해줘야 함
    printNumbers(emptyList()) //emptyList도 타입추론이 가능하면 타입을 생략할 수 있다.

    // 하나를 가져오기
    println(numbers[0])

    // For Each
    for(number in numbers) {
        println(number)
    }

    // 전통적인 For문
    for ((idx, value) in numbers.withIndex()) {
        println("${idx} ${value}")
    }

    //2. Set
    val numberSet = setOf(100, 200) //불변 집합
    val numberMutableSet = mutableSetOf(100, 200) //가변 집합 - 기본 구현체는 LinkedHashSet

    // For Each
    for (number in numbers) {
        println(number)
    }

    // 전통적인 For문
    for ((idx, value) in numbers.withIndex()) {
        println("${idx} ${value}")
    }

    //3. Map
    val map = mutableMapOf<Int, String>() //가변 Map - 타입을 추론할 수 없어, 타입을 지정해줘야 한다.
    map[1] = "MONDAY"
    map[2] = "TUESDAY"

    mapOf(1 to "MONDAY", 2 to "TUESDAY") //불변 Map

    // Map 활용
    for (key in map.keys) {
        println(key)
        println(map[key])
    }

    for ((key, value) in map.entries) {
        println(key)
        println(value)
    }
}

private fun printNumbers(numbers: List<Int>) {

}
