// where을 사용한 파라미터 타입 제한
// 여러 조건을 넣을 수 있다.
// close() 메서드가 있는 AutoCloseable, Appendable 인터페이스를 구현한 타입만 받도록 제한
fun <T> useAndClose(input: T) where T : AutoCloseable, T : Appendable {
    input.append("there")
    input.close()
}

val writer = java.io.StringWriter()
writer.append("hello ")
useAndClose(writer)
println(writer)
