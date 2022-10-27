//인터페이스를 구현한 익명 객체
fun createRunnable(): Runnable {
    val runnable = object : Runnable { //Runnable 인터페이스를 구현
        override fun run() {
            println("You called......")
        }
    }
    return runnable
}
val aRunnable = createRunnable()
aRunnable.run() //You called......

//싱글 추상 메소드 인터페이스(Java8의 함수형 인터페이스)라면 메소드 이름을 명명하지 않고 바로 구현할 수 있다.
fun createRunnable2(): Runnable = Runnable { println("You called......?") }
val bRunnable = createRunnable2()
bRunnable.run() //You called......?

//둘 이상의 인터페이스를 구현한다면 리턴이 필요한 경우 반드시 리턴할 인스턴스 타입을 명시해줘야 한다.
fun createRunnable3(): Runnable = object: Runnable, AutoCloseable { //Runnable과 AutoCloseable를 구현. 리턴타입은 Runnable
    override fun run() {
        println("You called.......!")
    }

    override fun close() {
        println("closing...")
    }
}
