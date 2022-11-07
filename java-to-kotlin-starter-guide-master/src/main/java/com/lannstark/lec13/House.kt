package com.lannstark.lec13

fun main() {

}

class House(
    private val address: String,
    private val livingRoom: LivingRoom,
    private val innerLivingRoom: InnerLivingRoom,

    ) {

    //Java의 static 중첩 클래스 (권장되는 클래스 안의 클래스)
    class LivingRoom(
        private val area: Double
    )

    //Java의 내부 클래스 (권장되지 않는 클래스 안의 클래스)
    inner class InnerLivingRoom( //inner 키워드를 붙여줘야 한다.
        private val area: Double
    ) {
        //바깥 클래스에 대한 참조를 가진다.
        //바깥 클래스의 address를 가져오기 위해 custom getter를 사용
        val address: String
            get() = this@House.address //this@상위클래스.필드
    }

}
