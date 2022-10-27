//데이터 클래스
data class Task(val id: Int, val name: String, val completed: Boolean, val assigned: Boolean)

val task1 = Task(1, "Create Project", false, true)
println(task1) //Task(id=1, name=Create Project, completed=false, assigned=true)
println("Name: ${task1.name}") //Name: Create Project

//copy() : 대상 객체의 모든 속성을 복사해서 새 객체를 생성하는 메소드
val task1Completed = task1.copy(completed = true, assigned = false) //복사하면서 속성 2개를 변경
println(task1Completed) //Task(id=1, name=Create Project, completed=true, assigned=false)

//componentN() : 주 생성자에 의해서 정의된 각각의 속성에 접근할 수 있게 해주는 메소드
// 구조 분해
val id = task1.id
val isAssigned = task1.assigned
println("Id: $id Assigned: $isAssigned") //Id: 1 Assigned: true

//데이터 클래스의 구조분해 기능
//- 주 생성자가 만든 속성 순서와 동일한 속성 순서로 속성을 추출
//- 언더스코어(`_`) : skip할 속성
val (id2, _, _, isAssigned2) = task1
println("Id2: $id2 Assigned2: $isAssigned2") //Id2: 1 Assigned2: true
