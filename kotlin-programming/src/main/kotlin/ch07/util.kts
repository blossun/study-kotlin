//객체 선언을 이용한 싱글톤
// object 키워드와 {} 블록 사이에 이름을 넣는다면, 코틀린은 이를 표현식이 아니라 명령문 또는 선언(Declaration)으로 인식한다.
object Util {
    fun numberOfProcessors() = Runtime.getRuntime().availableProcessors()
}
println(Util.numberOfProcessors()) //12
