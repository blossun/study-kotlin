package ch03

fun greetMany(message: String, vararg names: String) {
    println("$message ${names.joinToString(", ")}")
}

greetMany("Hello", "Rinjyu", "Kotlin")
