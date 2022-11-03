package dev.solar.todo.model.http

import dev.solar.todo.database.Todo
import java.lang.Exception
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.validation.constraints.AssertTrue
import javax.validation.constraints.NotBlank

data class TodoDto(
    var index: Int? = null,
    @field:NotBlank
    var title: String? = null,
    var description: String? = null,
    @field:NotBlank
    // yyyy-MM-dd HH:mm:ss
    var schedule: String? = null,
    var createdAt: LocalDateTime? = null,
    var updatedAt: LocalDateTime? = null
) {
    //TODO 이전에 학습했던 custom annotation으로 변경
    @AssertTrue(message = "yyyy-MM-dd HH:mm:ss 포맷이 맞지 않습니다.") //이 검증은 TodoDto를 만들때는 동작하지 않고, 스프링에서 컨트롤러 받을 때 @Validated 수행할 때 검증되는 건가?
    fun validSchedule(): Boolean {
        return try {
            LocalDateTime.parse(this.schedule, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
            true
        } catch (e: Exception) {
            false
        }

    }
}

//Todo를 TodoDto 변환해주는 확장함수 추가
fun TodoDto.convertTodoDto(todo: Todo): TodoDto {
    return TodoDto().apply {
        this.index = todo.index
        this.title = todo.title
        this.description = todo.description
        this.schedule = todo.schedule?.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
        this.createdAt = todo.createdAt
        this.updatedAt = todo.updatedAt
    }
}
