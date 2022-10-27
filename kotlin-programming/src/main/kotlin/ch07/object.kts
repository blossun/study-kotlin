// 객체 표현식으로 사용하는 익명 객체
fun drawCircle() {
    val circle = object { //an expression
        val x = 10
        val y = 20
        val radius = 30
    }
    println("Circle x: ${circle.x} y: ${circle.y} radius: ${circle.radius}") //Circle x: 10 y: 20 radius: 30
}
drawCircle()
