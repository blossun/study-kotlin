fun canVoteExpression(name: String, age: Int): String {
    var status: String
    if (age > 17) { //명령문 - 리턴값이 없다. 따라서 뮤터블 변수 status를 만들어서, 메소드 안에서 해당 변수를 수정해야 한다.
        status = "yes, please vote!"
    } else {
        status = "nope, please come back!"
    }

    return "$name, $status"
}

fun canVoteStatement(name: String, age: Int): String {
    val status = if (age > 17) "yes, please vote!" else "nope, please come back!" //표현식 - if를 호출하고, 결과를 사용할 수 있따.
    return "$name, $status"
}

println(canVoteExpression("Solar", 20))
println(canVoteStatement("Solar", 15))
