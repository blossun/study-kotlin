val fruits: List<String> = listOf("Apple", "Banana", "Grape", "Orange")
println(fruits) //[Apple, Banana, Grape, Orange]

// 요소접근 - get(), 인덱스([]) 연산자
println("first's ${fruits[0]}, that's ${fruits.get(0)}")

// 콜렉션에 값이 있는지 확인 - contains(), in 연산자
println(fruits.contains("Apple")) //first's Apple, that's Apple
println("Apple" in fruits) //true

//fruits.add("Orange") //ERROR Unresolved reference: add

// + 연산자 : 기존 리스트를 카피하면서 새로운 리스트를 만들고 새로운 요소를 추가한다.
val addMelon = fruits + "Melon"
println(fruits) //[Apple, Banana, Grape, Orange]
println(addMelon) //[Apple, Banana, Grape, Orange, Melon]

// - 연산자 : 기존 리스트에서 특정 요소를 제외한 새로운 리스트를 만든다.
val noBanana = fruits - "Banana"
println(noBanana) //[Apple, Grape, Orange] //제가하려는 요소가 현재 리스트에 없다면 아무것도 제거되지 않은 동일한 리스트가 만들어진다.

println(fruits::class)
println(fruits.javaClass)

val mutableFruits: MutableList<String> = mutableListOf("Apple", "Banana");
println(mutableFruits::class)
mutableFruits.add("Melon")
println(mutableFruits)
