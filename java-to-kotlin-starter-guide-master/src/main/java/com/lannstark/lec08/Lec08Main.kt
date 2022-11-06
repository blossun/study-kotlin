package com.lannstark.lec08

fun main() {
    //2. default parameter ======================================================================
    repeat("a") //a\na\na
    repeat("a", 5, false) //aaaaa

    //3. named argument =========================================================================
    //repeat을 호출할 때,
    //num은 3을 그대로 쓰고 useNewLine은 false를 쓰고 싶다면?
    // 어떤 parameter에 이 값을 넣을 것이라고 함수를 호출하는 쪽에서 명시해줄 수 있다.
    repeat("h", useNewLine = false) //hhh

    //3. named parameter의 장점 - builder를 직접 만들지 않고 builder의 장점을 가지게 된다. =================
    printNameAndGender("FEMALE", "Solar") //실수를 컴파일단에서 잡을 수 없다.
    printNameAndGender(gender = "FEMALE", name = "Solar") //확실하게 명시할 수 있다.

    //Kotlin에서 Java 함수를 가져다 사용할 때는 named argument를 사용할 수 없다.
    // why?
    // 코틀린에서 Java 함수를 가져다 쓸 때, JVM 상에서 Java가 바이트 코드로 변환됐을 때 parameter 이름을 보존하고 있지 않기 때문에
    // 코틀린에서는 파라미터 이름을 통해서 가져오는 named argument를 쓸 수 없다.
//    Lec08Main.repeatJava(str = "a") //ERROR

    //4. 가변인자를 활용할 때는 ======================================================================
    // (1) 배열을 넣어준다. - 배열을 가변인자에 넣어줄 때는 앞에 별표(*)를 붙여줘야 한다.
    val array = arrayOf("A", "B", "C")
    printAll(*array) // * : spread 연산자 - 배열 안에 있는 것들을 마치 그냥 , 를 쓰는 것처럼 꺼내준다.
    // (2) comma로 구분 - 자바와 동일
    printAll("ha", "hi", "ho")


}

//1. 함수 선언 문법
//함수는 클래스 안에 있을 수도, 파일 최상단에 있을 수도 있습니다. 또한, 한 파일 안에 여러 함수들이 있을 수도 있다.
//block { } 을 사용하는 경우에는 반환 타입이 Unit이 아니면, 명시적으로 작성해주어야 한다.

fun max(a: Int, b: Int): Int {
    return if (a > b) { //if ~ else는 expression
        a
    } else {
        b
    }
}

// 위 코드는 아래처럼 바꿀 수 있다.
// 함수가 하나의 결과값이면 block 대신 = 사용 가능
// return키워드와 중괄호{}를 없애고 = 을 쓰면 된다.
// 즉, "중괄호 안에서 return으로 어떤 값을 준다"라고 표현하는 대신에
// "이 함수의 값은 이것의 결과물(expression)이야"라고 알려주는 것이다.
fun max2(a: Int, b: Int) = if (a > b) a else b // =을 사용하는 경우 반환 타입 생략 가능

//2. default parameter
//자바는 OverLoading을 이용해서 기본값을 사용한다.
fun repeat(
    str: String,
    num: Int = 3,
    useNewLine: Boolean = true
) {
    for (i in 1..num) {
        if (useNewLine) {
            println(str)
        } else {
            print(str)
        }
    }
}

//3. named parameter의 장점
fun printNameAndGender(name: String, gender: String) { //동일한 타입의 인자 2개를 입력받는다. gender와 name이 바뀌어서 들어와도 컴파일단에서 오류가 발생하지 않는다.
    println(name)
    println(gender)
}

//4. 같은 타입의 여러 파라미터 받기 (가변인자)
//문자열을 N개 받아 출력하는 예제
fun printAll(vararg strings: String) {
    for (str in strings) {
        println(str)
    }
}

