package com.lannstark.lec03

fun main() {
    val number1 = 3
    //val number2: Long = number1 // ERROR. type mismatch 암시적 형변환 안됨
    val number2: Long = number1.toLong() //명시적 형변환 필수 (암시적 형변환 안됨)

    //변수가 nullable이라면 적절한 처리가 필요
    val number3: Int? = 3
    val number4: Long = number3?.toLong() ?: 0L //null일 경우에 대한 처리를 추가해줘야 한다.

    val person = Person("solar", 100)
    printAgeIfPerson(person)
    printAgeIfPersonNullable(null)

    //String interpolation
    println("name is ${person.name}, age is ${person.age}") //$변수 도 가능하지만 ${변수} 가 가독성이 좋다.
    println("""
        ${person.name}
        이렇게 
        여러줄 입력이
        가능합니다 ^^
    """.trimIndent())

    //String indexing
    val str = "ABC"
    println(str[0])
}

fun printAgeIfPerson(obj: Any) {
    if (obj is Person) { //is : Person 타입인지 확인
        //1. as Person : Person으로 간주한다. (생략가능)
        val person = obj as Person
        println(person.age)

        //2. obj가 스마트캐스팅에 의해서 바로 person의 필드를 사용할 수 있다.
        println(obj.age)
    }

    if (obj !is Person) { //!is : Person 타입이 아닌지 확인
        println("obj is not Person")
    }
}

//만약 obj에 null이 들어올 수 있다면?!
fun printAgeIfPersonNullable(obj: Any?) {
    val person = obj as? Person //as? : obj가 null이 아니면 Person으로 타입변환을 시키고, null이면 이 구문 전체가 null이 된다.
    println(person?.age ?: 0)
}
