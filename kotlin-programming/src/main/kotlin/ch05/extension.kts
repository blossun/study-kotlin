val names = listOf("Solar", "Rachel")
println(names.javaClass)
for ((index, value) in names.withIndex()) {
    println("$index $value")
}
