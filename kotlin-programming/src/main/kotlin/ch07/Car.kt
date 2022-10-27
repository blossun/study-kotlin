package ch07

//yearOfMake, color 모두 필드가 아니고 속성이다. 코틀린에서는 클래스에 필드가 없다.
//`car.yearOfMake` 를 호출하면 실제로는 `car.getYearOfMake()`를 호출한 것이다.
class Car(val yearOfMake: Int, var color: String)

//javap 툴을 이용해서 코드를 컴파일하고 바이트코드를 살펴보자
//kotlinc-jvm Car.kt //Car.class 파일을 만들어준다. (package가 있다면 package 하위 경로에)
//javap -p Car.calss //class 파일 디셈블러
