package com.lannstark.lec02

fun main() {

}

//1. null이면 exception 발생
fun startsWithA1(str: String?): Boolean {
    if (str == null) {
        throw IllegalArgumentException("null이 들어왔습니다")
    }
    return str.startsWith("A")
}


//2. null이면 null반환. 반환 타입은 null이 가능한 reference타입
fun startsWithA2(str: String?): Boolean? {
    if (str == null) {
        return null
    }
    return str.startsWith("A")
}


//3. null이면 false를 반환
fun startsWithA3(str: String?): Boolean {
    //null체크없이 str에서 바로 starsWith를 호출하면 에러가 난다.
    if (str == null) {
        return false
    }
    //코틀린은 문맥상 위에서 null을 한 번 체크 해주면 그 다음코드에서는 null이 아님을 컴파일러가 추측해서 바로 startsWith를 호출할 수 있다.
    return str.startsWith("A")
}
