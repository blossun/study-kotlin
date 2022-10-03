package ch03

fun greet(name: String, message: String = "Hi ${name.length}") = "$message $name"

println(greet("Solar"))
println(greet("Solar", "Developer"))
