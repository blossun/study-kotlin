//컴패니언 객체와 클래스 멤버
class MachineOperator(val name: String) {
    fun checkin() = checkedIn++
    fun checkout() = checkedIn--

    //컴페니언 객체
//    companion object { //1. 컴패니언 객체에 이름이 없는 경우
    companion object MachineOperatorFacotry{ //2. 컴패니언 객체에 이름을 지정
        var checkedIn = 0 //클래스 레벨 속성
        fun minimumBreak() = "15 minutes every 2 hours" //클래스 레벨 메소드
    }
}

val solarMachine = MachineOperator("Solar").checkin()
println(MachineOperator.minimumBreak()) //15 minutes every 2 hours
println(MachineOperator.checkedIn) //1
//println(solarMachine.minimumBreak()) //ERROR. 컴패니언 메소드는 인스턴스를 이용해서 접근할 수 없다.

//컴패니언에 접근하는 방법
//val ref = MachineOperator.Companion //1. Companion은 컴패니언 객체에 명확한 이름이 없을 경우에만 사용
val ref = MachineOperator.MachineOperatorFacotry //2. 컴패니언 객체에 지정된 이름을 사용. Companion은 사용 불가
println(ref.checkedIn)



