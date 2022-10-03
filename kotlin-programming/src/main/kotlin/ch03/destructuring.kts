package ch03

fun getFullName() = Triple("Solar", "Rachel", "Anne")

fun destructuring1() {
    val result = getFullName()
    val first = result.first
    val middle = result.second
    val last = result.third

    println("$first $middle $last")
}

fun destructuring2() {
    val (first, middle, last) = getFullName()
    println("$first $middle $last")
}

fun destructuring3() {
    val (first, _, last) = getFullName()
    println("$first $last")
}

fun destructuring4() {
    val (_, _, last) = getFullName()
    println(last)
}

fun destructuring5() {
    val (_, middle) = getFullName()
    println(middle)
}

destructuring1()
destructuring2()
destructuring3()
destructuring4()
destructuring5()
