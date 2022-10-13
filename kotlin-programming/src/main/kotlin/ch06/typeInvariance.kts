open class Fruit
class Banana: Fruit()
class Orange: Fruit()

fun receiveFruitsArray(fruits: Array<Fruit>) {
    println("Number of fruits : ${fruits.size}")
}
val oranges: Array<Orange> = arrayOf()
//receiveFruitsArray(oranges) // ERROR - type mismatch

fun receiveFruitsList(fruits: List<Fruit>) {
    println("Number of fruits: ${fruits.size}")
}

val bananas: List<Banana> = listOf()
receiveFruitsList(bananas) //OK
