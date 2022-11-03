package dev.solar.todo.model.http

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.validation.FieldError
import javax.validation.Validation

class TodoDtoTest {

    val validator = Validation.buildDefaultValidatorFactory().validator

    @Test
    fun todoDtoTest() {
        val todoDto = TodoDto().apply {
            this.title = "테스트"
            this.description = ""
            this.schedule = "2022-11-02 13:00"
        }

        val result = validator.validate(todoDto)

        // 테스트 실패했을 때 찍어봐서 확인해보면 된다.
        result.forEach {
            println(it.propertyPath.last().name)
            println(it.message)
            println(it.invalidValue)
        }

        Assertions.assertTrue(result.isEmpty())
    }
}
