// 파라미터 타입 제한
// close() 메서드가 있는 AutoCloseable 인터페이스를 구현한 타입만 받도록 제한
// 이 방식으로는 한가지 조건만 넣을 수 있다. 여러 조건을 넣으려면 where을 사용해야하다.
fun <T: AutoCloseable> useAndClose(input: T) {
    input.close()
}

val writer = java.io.StringWriter()
writer.append("hello ")
useAndClose(writer)
println(writer)
