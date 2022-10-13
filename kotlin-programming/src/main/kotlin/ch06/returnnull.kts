fun nickName(name: String?): String? {
    if (name == "Solar") {
        return "Holar"
    }

    //1. 지저분한 null 체크 -> 세이프 콜 연산자를 이용해서 깨끗하게 고쳐보자
//    if (name != null) {
//        return name.reversed()
//    }
//    return null

    //2. 세이프콜 - ?
    //세이프콜 연산자로 연결할 수 있다.
    //타깃이 null일 경우에 null을 리턴한다.
//    return name?.reversed()?.toUpperCase();

    //3. 엘비스 연산자 - ?:
    //참조가 null이면 null이 아닌 값을 리턴할 수 있다.
//    return name?.reversed()?.toUpperCase() ?: "Joker";

    //4. 확정 연산자 - !!
    return name!!.reversed().toUpperCase() //no-error but BAD CODE
}

println("Nickname for Solar is ${nickName("Solar")}")
println("Nickname for Kolar is ${nickName("Kolar")}")
println(nickName(null))
