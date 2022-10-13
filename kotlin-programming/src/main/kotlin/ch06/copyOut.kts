open class Fruit
class Banana : Fruit()

// 공변성 사용하기 - out
fun copyFromTo(from: Array<out Fruit>, to: Array<Fruit>) {
    for (i in 0 until from.size) {
        to[i] = from[i]
        //아래와 같이 from data에 쓰기 작업을 하는 코드가 있다면 컴파일에러가 난다.
//        from[i] = Fruit()
//        from.set(i, to[i])
    }
}

val fruitsBasket1 = Array<Fruit>(3) { _ -> Fruit() }
val fruitsBasket2 = Array<Fruit>(3) { _ -> Fruit() }
copyFromTo(fruitsBasket1, fruitsBasket2) //OK

val fruitsBasket = Array<Fruit>(3) { _ -> Fruit() }
val bananaBasket = Array<Banana>(3) { _ -> Banana() }
copyFromTo(bananaBasket, fruitsBasket) //OK
