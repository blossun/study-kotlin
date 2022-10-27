// 클래스에 속성 정의
class Car(val yearOfMake: Int) //주생성자, yearOfMake : 읽기 전용 속성

val car = Car(2019) //인스턴스 생성
println(car.yearOfMake) //2019
//car.yearOfMake = 2020 //ERROR. Val cannot be reassigned
