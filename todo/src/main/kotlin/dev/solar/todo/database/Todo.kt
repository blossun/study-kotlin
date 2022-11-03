package dev.solar.todo.database

import dev.solar.todo.model.http.TodoDto
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class Todo(
    var index: Int? = null,                 // 일정 index
    var title: String? = null,              // 일정 타이틀
    var description: String? = null,        // 일정 설명
    var schedule: LocalDateTime? = null,    // 일정 시간
    var createdAt: LocalDateTime? = null,   // 생성 시간
    var updatedAt: LocalDateTime? = null,   // 업데이트 시간
)

//TodoDto를 Todo Entity로 변환해주는 확장함수 추가
// 직접 확장함수 코드를 작성하는 방법 외에 modelMapper, 코틀린 리플렉션을 사용하는 방법도 있다.
fun Todo.convertTodo(todoDto: TodoDto): Todo {
    return Todo().apply {
        this.index = todoDto.index
        this.title = todoDto.title
        this.description = todoDto.description
        this.schedule = LocalDateTime.parse(todoDto.schedule, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) //앞단에서 validator로 포멧검증을 했으므로 변환 시 문제가 없다.
        this.createdAt = todoDto.createdAt
        this.updatedAt = todoDto.updatedAt
    }
}
