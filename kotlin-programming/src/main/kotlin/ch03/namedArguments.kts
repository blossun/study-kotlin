package ch03

fun createPerson(name: String, age: Int = 1, height: Int, weight: Int) {
    println("$name $age $height $weight")
}

createPerson("Solar", 20, 170, 40)
createPerson("Solar", age = 20, weight = 40, height = 170)
createPerson("Solar", 20, weight = 40, height = 170)
createPerson(weight = 40, height = 170, name = "Solar") //age는 기본값이 있어서 생략 가능
createPerson("Solar", weight = 40, height = 170)
