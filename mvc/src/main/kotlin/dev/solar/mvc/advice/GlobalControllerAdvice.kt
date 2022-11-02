package dev.solar.mvc.advice

import dev.solar.mvc.controller.exception.ExceptionApiController
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

// @RestControllerAdvice : @RestController에서 글로벌하게 발생하는 Exception을 핸들링
// @ControllerAdvice : @Controller에서 글로벌하게 발생하는 Exception을 핸들링
// Exception을 잡을 controller를 제한할 수도 있다.
// ex) basePackages : 특정 패키지 경로에 있는 @RestController
//@RestControllerAdvice(basePackageClasses = [ExceptionApiController::class]) //실습을 위해 글로벌 익셉션 핸들러 비활성화
class GlobalControllerAdvice {
    @ExceptionHandler(value = [RuntimeException::class]) //처리할 Exception을 지정
    fun exception(e: RuntimeException): String {
        return "Server Error"
    }

    @ExceptionHandler(value = [IndexOutOfBoundsException::class])
    fun indexOutOfBoundsException(): ResponseEntity<String> {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Index Error")
    }
}
