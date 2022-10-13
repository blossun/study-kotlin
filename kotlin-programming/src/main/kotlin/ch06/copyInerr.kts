open class Fruit
class Banana : Fruit()

// 반공변성 사용하기 - in
fun copyFromTo(from: Array<out Fruit>, to: Array<in Fruit>) {
    for (i in 0 until from.size) {
        to[i] = from[i]
    }
}

val fruitsBasket1 = Array<Fruit>(3) { _ -> Fruit() }
val fruitsBasket2 = Array<Fruit>(3) { _ -> Fruit() }
copyFromTo(fruitsBasket1, fruitsBasket2) //OK

val things = Array<Any>(3) { _ -> Fruit() } //부모타입의 Any
val bananaBasket = Array<Banana>(3) { _ -> Banana() }
copyFromTo(bananaBasket, things) //OK
