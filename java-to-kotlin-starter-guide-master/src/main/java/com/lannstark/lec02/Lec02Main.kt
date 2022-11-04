package com.lannstark.lec02

fun main() {
    println(startsWith("ABC"))
}

//1. null이면 exception 발생
fun startsWithA1(str: String?): Boolean {
    //safe call과 ebl
    //safe call ?. : null이 아니면 실행하고, null이면 실행하지 않는다 (그대로 null)
    // Elvis 연산자 ?: : 앞의 연산 결과가 null이면 뒤의 값을 사용
    return str?.startsWith("A") ?: throw IllegalArgumentException("null이 들어왔습니다")
}


//2. null이면 null반환. 반환 타입은 null이 가능한 reference타입
fun startsWithA2(str: String?): Boolean? {
    return str?.startsWith("A")
}


//3. null이면 false를 반환
fun startsWithA3(str: String?): Boolean {
    //null체크없이 str에서 바로 starsWith를 호출하면 에러가 난다.
    //코틀린은 문맥상 위에서 null을 한 번 체크 해주면 그 다음코드에서는 null이 아님을 컴파일러가 추측해서 바로 startsWith를 호출할 수 있다.
    return str?.startsWith("A") ?: false
}

// 널 아님 단언 !! : nullable type이지만, 아무리 생각해도 null이 될 수 없는 경우
// 혹시나 null이 들어오면 NPE가 나오기 때문에
// 정말 null이 아닌게 확실한 경우에만 널 아님 단언!! 을 사용해야 한다.
fun startsWith(str: String?): Boolean {
    return str!!.startsWith("A")
}
