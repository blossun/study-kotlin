package dev.solar.todo.handler

import dev.solar.todo.controller.api.todo.TodoApiController
import dev.solar.todo.model.http.ErrorResponse
import dev.solar.todo.model.http.Error
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.FieldError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.time.LocalDateTime
import javax.servlet.http.HttpServletRequest

@ControllerAdvice(basePackageClasses = [TodoApiController::class])
class TodoApiControllerAdvice {
    @ExceptionHandler(value = [MethodArgumentNotValidException::class])
    fun methodArgumentNotValidException(e: MethodArgumentNotValidException, request: HttpServletRequest): ResponseEntity<ErrorResponse> {
        val errors = mutableListOf<Error>()

        e.bindingResult.allErrors.forEach { errorObject -> //it을 errorObject로 형변환
            Error().apply {
                val field = errorObject as FieldError
                this.field = field.field
                this.message = errorObject.defaultMessage
                this.value = errorObject.rejectedValue //reject된 value 즉, 사용자 입력값
            }.apply {
                errors.add(this)
            }
        }

        val errorResponse = ErrorResponse().apply {
            this.resultCode = "FAIL"
            this.httpStatus = HttpStatus.BAD_REQUEST.value().toString() //400
            this.httpMethod = request.method
            this.message = "요청에 에러가 발생했습니다."
            this.path = request.requestURI.toString() //현재 요청한 request의 uri 정
            this.timestamp = LocalDateTime.now()
            this.errors = errors
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse)
    }
}
