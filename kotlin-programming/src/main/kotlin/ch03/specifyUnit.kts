package ch03

fun sayHello() = println("Well, hello")
//val message: String = sayHello() //ERROR : Type mismatch: inferred type is Unit but String was expected
val message2: Unit = sayHello()

println("The result of sayHello is $message2")
