package ch03

fun greet() = "Hello" //리턴타입을 추론해주기 때문에 리턴타입을 생략할 수 있다.
println(greet())

//리턴타입 추론은 컴파일할 때 진행된다.
//Int형 변수에 greet() 결과를 할당하려고 하면 컴파일 오류가 발생한다.
//val message: Int = greet() //Type mismatch: inferred type is String but Int was expected


