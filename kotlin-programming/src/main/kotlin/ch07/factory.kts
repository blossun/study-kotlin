//MachineOperator 클래스가 팩토리를 사용하도록 변경
class MachineOperator private constructor(val name: String) { //1.클래스에 privatre 생성자를 만든다.
    fun checkin() = checkedIn++
    fun checkout() = checkedIn--

    //컴페니언 객체
    companion object {
        var checkedIn = 0 //클래스 레벨 속성
        fun minimumBreak() = "15 minutes every 2 hours" //클래스 레벨 메소드

        //팩토리
        fun create(name: String): MachineOperator {
            val instance = MachineOperator(name)
            instance.checkin() //인스턴스를 리턴하기 전에 사전 작업
            return instance
        }
    }
}

val operator = MachineOperator.create("Solar")
println(MachineOperator.checkedIn) //1
println(operator.name) //Solar
