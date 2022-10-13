fun nickName(name: String): String {
    if (name == "Solar") {
        return "Holar"
    }
//    return null // compile error - Null can not be a value of a non-null type String
    return "HaHa"
}

println("Nickname for Solar is ${nickName("Solar")}")
println("Nickname for Kolar is ${nickName("Kolar")}")
//println(nickName(null)) // compile error - Null can not be a value of a non-null type String
