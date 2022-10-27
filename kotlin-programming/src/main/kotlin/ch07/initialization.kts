import java.lang.RuntimeException

class Car(val yearOfMake: Int, theColor: String) {
    var fuelLevel = if (yearOfMake < 2020) 90 else 100
        private set //setter 접근 제어자 변경
    var color = theColor
        set(value) {
            if (value.isBlank()) {
                throw RuntimeException("no empty, please")
            }
            field = value
        }
}
