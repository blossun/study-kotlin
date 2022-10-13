class Animal {
    override operator fun equals(other: Any?) = other is Animal
}

val greet: Any = "hello"
val odie: Any = Animal()
val toto: Any = Animal()

println(odie == greet)
println(odie == toto) //equals() 메소드를 == 연산자로 사용할 수 있다.
