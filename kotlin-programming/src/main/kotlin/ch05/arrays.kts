val friends = arrayOf("Solar", "Rachel")
println(friends::class)
println(friends.javaClass)
println("${friends[0]} and ${friends[1]}")

val numbers = arrayOf(1, 2, 3)
println(numbers::class)
println(numbers.javaClass)
println(numbers.size)
println(numbers.average())

val intNumbers = intArrayOf(1, 2, 3)
println(intNumbers::class)
println(intNumbers.javaClass)
println(intNumbers.size)
println(intNumbers.average())

println(Array(5) { i -> (i + 1) * (i + 1)}.sum())
