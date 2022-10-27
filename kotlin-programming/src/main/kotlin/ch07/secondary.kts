// 보조 생성자
class Person(val first: String, val last: String) { //주 생성자 - 주 생성자에서의 constructor 키워드는 선택사항
    var fulltime = true //클래스 내부에서 선언된 속성
    var location: String = "-"
    // 보조 생성자 1
    constructor(first: String, last: String, fte: Boolean): this(first, last) { //this() -> 주 생성자 호출
        fulltime = fte
    }
    // 보조 생성자 2
    constructor(first: String, last: String, loc: String) : this(first, last, false) {//this() -> 보조 생성자 1 호출
        location = loc
    }
    override fun toString() = "$first $last $fulltime $location"
    internal fun fullName() = "$last, $first"
    private fun yearsOfService(): Int = throw RuntimeException("Not implemented yet")
}

println(Person("Solar", "Kim")) //Solar Kim true -
println(Person("Solar", "Kim", false)) //Solar Kim false -
println(Person("Solar", "Kim", "home")) //Solar Kim false home

val solar = Person("Solar", "Kim")
println(solar.fullName())
//println(solar.yearsOfService()) //ERROR. Cannot access 'yearsOfService'
