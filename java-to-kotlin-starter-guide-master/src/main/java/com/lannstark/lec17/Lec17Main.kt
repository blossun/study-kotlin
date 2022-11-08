package com.lannstark.lec17

fun main() {
    val fruits = listOf(
        Fruit("사과", 1000),
        Fruit("사과", 1200),
        Fruit("사과", 1200),
        Fruit("사과", 1500),
        Fruit("바나나", 3000),
        Fruit("바나나", 3200),
        Fruit("바나나", 2500),
        Fruit("수박", 10000)
    )

    // 변수에 함수를 담을 수 있다.
    // 함수에도 타입이 있다. 아래 함수는 Fruit을 받아서 Boolean을 반환하는 타입이다.
    //이 과일이 사과야? 라는 함수를 변수에 담는다.
    // 람다를 만드는 방법 1
    val isApple: (Fruit) -> Boolean = fun(fruit: Fruit): Boolean { //함수에 이름이 없다. 즉 이름없는 함수 "람다"
        return fruit.name == "사과"
    }

    // 람다를 만드는 방법 2
    val isApple2: (Fruit) -> Boolean = { fruit: Fruit -> fruit.name == "사과" } //축약된 형태

    // 람다를 호출하는 방법 1
    println(isApple(fruits[0])) //방법1. ()를 이용해서 호출 - isApple자체가 함수이기 때문에 소괄호로 바로 호출 가능
    // 람다를 호출하는 방법 2
    println(isApple.invoke(fruits[1])) //방법2. invoke를 직접 호출한다.

    // 람다를 인자로 넘기는 방법1
    filterFruits(fruits, isApple)
    // 람다를 인자로 넘기는 방법2 - 사용할 때 만들어서 넘겨도 된다.
    filterFruits(fruits, {fruit: Fruit -> fruit.name == "바나나"})

    // 람다를 인자로 넘기는 방법3 - 중괄호와 화살표를 활용하는 형태를 함수에 넣어줄 떄, 함수에서 받는 함수파라미터가 마지막에 위치해 있으면
    // 소괄호() 밖으로 중괄호{}를 뺄 수 있다.
    // 중괄호가 함수를 호출할 때 가장 마지막 파라미터로 들어가게 된다.
    filterFruits(fruits) { fruit: Fruit ->
        println("바나나만 받는다..!!!")
        fruit.name == "바나나"  //람다 본문을 여러줄 작성할 수 있고, 마지막 줄의 결과가 람다의 반환값이다. (return 명시 안해줘도 ok)
    }

    // 람다를 인자로 넘기는 방법4 - 함수에 들어가야할 파라미터 타입을 추론할 수 있기 때문에 타입을 생략 가능하다.
    filterFruits(fruits) { a -> a.name == "바나나" } //a가 Fruit 이라는 것도 추론 가능. (이 방법을 추천)

    // 람다를 인자로 넘기는 방법5 - 익명함수를 만들 때 파라미터가 한 개인 경우
    // `it` 키워드를 사용하면 이 `it`이 곧 람다로 들어오는 파라미터가 된다.
    filterFruits(fruits) { it.name == "바나나" } //여기서 it이 fruit하나를 가르키게 된다. (함수를 부르는 쪽 코드만 봐서는 it이 어떤 데이터인지 잘 모른다.)
}

//Java에서 처럼 Predicate 같이 함수 인터페이스를 쓰는 것이 아니라 정말 함수 자체를 파라미터로 받아서 필터링 함수를 사용하게 된다.
private fun filterFruits(
    fruits: List<Fruit>,
    fruitFilter: (Fruit) -> Boolean
): List<Fruit> {
    val results = mutableListOf<Fruit>()
    for (fruit in fruits) {
        if (fruitFilter(fruit)) {
            results.add(fruit)
        }
    }
    return results
}
