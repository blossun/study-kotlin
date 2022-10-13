class Animal(val age: Int) {
    override operator fun equals(other: Any?):Boolean {
        return if (other is Animal) age == other.age else false
    }
}

var odie = Animal(2)
var toto = Animal(2)
var butch = Animal(3)

println(odie == toto)
println(odie == butch)