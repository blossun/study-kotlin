package ch03

fun max(vararg numbers: Int): Int {
    var large = Int.MIN_VALUE
    for (number in numbers) {
        large = if (number > large) number else large
    }

    return large
}

println(max(1, 5, 2))
println(max(1, 5, 2, 12, 7 , 3))

val values = intArrayOf(1, 20, 5)
println(max(values[0], values[1], values[2]))
//println(max(values)) //ERROR - 배열이나 리스트를 직접 넘길 수 없다.
println(max(*values)) //스프레드 연산자 (*)를 이용해서 넘길 수 있다.
println(max(*listOf(1, 4, 18, 12).toIntArray())) //리스트를 배열로 변환해서 스프레드 연산자를 적용할 수 있다.
