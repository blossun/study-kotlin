package ch07

//yearOfMake, color는 필드가 아니고 속성이다. 코틀린에서는 클래스에 필드가 없다.
fun useCarObject(): Pair<Int, String> {
    val car = Car(2019, "Red")
    val year = car.yearOfMake
    car.color = "Green"
    val color = car.color
    return year to color
}
