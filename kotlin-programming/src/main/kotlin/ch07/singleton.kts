// 싱글톤이 부모 클래스나 인터페이스를 가지고 있다면 싱글톤은 참조로 할당되거나 부모 타입의 파라미터로 전달될 수 있다.
object Sun : Runnable {
    val radiusInKM = 696000
    var coreTemperatureInC = 1500000 //싱글톤에 뮤터블한 상태를 두는 것은 좋지않다. 특히 멀티스레드 앱이라면 더 더욱
    override fun run() {
        println("spin...")
    }
}
fun moveIt(runnable: Runnable) { //싱글톤의 부모 타입의 파라미터로 전달 가능
    runnable.run()
}
println(Sun.radiusInKM) //696000 //싱글톤 속성에 접근
moveIt(Sun) //spin...
