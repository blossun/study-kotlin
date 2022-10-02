package ch02

val greet = "hello"
println(greet) //hello
println(greet::class) //class kotlin.String //변수에 의해 참조되고 있는 객체의 코틀린 클래스를 확인
println(greet.javaClass) //class java.lang.String //Java 클래스를 확인
