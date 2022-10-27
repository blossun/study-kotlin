// 뮤터블 속성
class Car(val yearOfMake: Int, var color: String)
val car = Car(2019, "Red")
car.color = "Green" //뮤터블 속성은 변경가능하다.
println(car.color) //Green
