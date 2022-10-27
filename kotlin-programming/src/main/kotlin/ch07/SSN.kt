package ch07

//inline 클래스
inline class SSN(val id: String)
fun receiveSSN(ssn: SSN) {
    println("Received $ssn")
}

fun main() {
    receiveSSN(SSN("111-11-1111"))
}
