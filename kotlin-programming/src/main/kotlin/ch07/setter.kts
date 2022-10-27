import java.lang.RuntimeException

class Car(val yearOfMake: Int, theColor: String) { // 속성1 : yearOfMake, 파라미터 : theColor(필드가 아님)
    var fuelLevel = 100 //속성2
    var color = theColor //속성2
    set(value) { //color의 setter를 재정의
        if (value.isBlank()) { //color의 validation을 체크
            throw RuntimeException("no empty, please")
        }
        field = value //field 키워드를 사용한 백킹 필드를 사용하지 않는다면 백킹 필드가 생성되지 않는다. setter나 getter 중 하나만 작성한다면 백킹 필드가 생성된다.
    }
    init {
        if (yearOfMake < 2020) {
            fuelLevel = 90 //fuelLevel 속성에 접근해야만 하기 때문에 fuelLevel을 정의하는 시점보다 init 블록이 앞에 있으면 안 된다.
        }
    }
}

val car = Car(2019, "Red")
car.color = "Green"
car.fuelLevel--
println(car.fuelLevel) //99
try {
    car.color = ""
} catch(ex: Exception) {
    println(ex.message) //no empty, please //message 속성을 이용 - getMessage()가 아닌
}
println(car.color) //Green
