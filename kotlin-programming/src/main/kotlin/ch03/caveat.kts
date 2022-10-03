package ch03

fun caveat1() = 2
fun caveat2() = { 2 }
fun caveat3(factor: Int) = { n: Int -> n * factor }

println(caveat1())
println(caveat2())
println(caveat2()())
println(caveat3(2))
println(caveat3(2)(3))
