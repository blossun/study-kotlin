package ch02

val greet = "hello"
println(greet) //hello
println(greet::class) //class kotlin.String //변수에 의해 참조되고 있는 객체의 코틀린 클래스를 확인
println(greet.javaClass) //class java.lang.String //Java 클래스를 확인

//greet = 0 //컴파일 시점에 greet 타입이 문자열이라고 판단한다. (타입 추론) 타입이 맞기 않아 컴파일 오류가 발생
