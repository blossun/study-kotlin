open class Fruit
class Banana: Fruit()

// 타입제한
fun copyFromTo(from: Array<Fruit>, to: Array<Fruit>) {
    for (i in 0 until from.size) {
        to[i] = from[i]
    }
}

//1.
val fruitsBasket1 = Array<Fruit>(3) { _ -> Fruit() }
val fruitsBasket2 = Array<Fruit>(3) { _ -> Fruit() }
copyFromTo(fruitsBasket1, fruitsBasket2) //OK

//2.
val fruitsBasket = Array<Fruit>(3) { _ -> Fruit() }
val bananaBasket = Array<Banana>(3) { _ -> Banana() }
//copyFromTo(bananaBasket, fruitsBasket) //ERROR - Type mismatch

