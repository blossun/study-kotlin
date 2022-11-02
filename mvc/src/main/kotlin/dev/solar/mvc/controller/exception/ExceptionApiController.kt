package dev.solar.mvc.controller.exception

import dev.solar.mvc.model.http.Error
import dev.solar.mvc.model.http.ErrorResponse
import dev.solar.mvc.model.http.UserRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.FieldError
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime
import javax.servlet.http.HttpServletRequest
import javax.validation.ConstraintViolationException
import javax.validation.Valid
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@RestController
@RequestMapping("/api/exception")
@Validated
class ExceptionApiController {

    @GetMapping("/hello")
    fun hello(): String {
        val list = mutableListOf<String>()
//        val temp = list[0]
        return "hello"
    }

    // 1. RequestParam Validation
    @GetMapping
    fun get(
        @NotBlank
        @Size(min = 2, max = 6)
        @RequestParam name: String,

        @Min(10)
        @RequestParam age: Int
    ): String {
        println(name)
        println(age)
        return "$name $age"
    }

    // 2. POST 요청시 Bean Validation
    @PostMapping
    fun post(@Valid @RequestBody userRequest: UserRequest): UserRequest {
        println(userRequest)
        return userRequest
    }

    // 2. POST 요청의 RequestBody에 대한 에러 핸들러
    @ExceptionHandler(value = [MethodArgumentNotValidException::class])
    fun methodArgumentNotValidException(e: MethodArgumentNotValidException, request: HttpServletRequest): ResponseEntity<ErrorResponse> {
        val errors = mutableListOf<Error>()

        e.bindingResult.allErrors.forEach { errorObject -> //it을 errorObject로 형변환
            val error = Error().apply {
                val field = errorObject as FieldError
                this.field = field.field
                this.message = errorObject.defaultMessage
                this.value = errorObject.rejectedValue //reject된 value 즉, 사용자 입력값
            }

            errors.add(error)
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

    // 1. GET 요청의 ReqeustParam에 대한 에러핸들러
    //ConstraintViolationException : 에러 정보를 가져올 수 있다.
    //HttpServletRequest : 스프링인 현재 Request에 대한 정보를 담아서 주입해준다.
    @ExceptionHandler(value = [ConstraintViolationException::class])
    fun constraintViolationException(e: ConstraintViolationException, request: HttpServletRequest): ResponseEntity<ErrorResponse> {
        // 1. 에러 분석
        val errors = mutableListOf<Error>()

        e.constraintViolations.forEach {
            var error = Error().apply {
                this.field = it.propertyPath.last().name //propertyPath 배열의 마지막 요소에 변수명이 들어있다.
                this.message = it.message
                this.value = it.invalidValue
            }
            errors.add(error) //에러가 발생한 필드정보(필드명, message)를 담는다.
        }

        // 2. ErrorResponse
        val errorResponse = ErrorResponse().apply {
            this.resultCode = "FAIL"
            this.httpStatus = HttpStatus.BAD_REQUEST.value().toString() //400
            this.httpMethod = request.method
            this.message = "요청에 에러가 발생했습니다."
            this.path = request.requestURI.toString() //현재 요청한 request의 uri 정
            this.timestamp = LocalDateTime.now()
            this.errors = errors
        }

        // 3. ResponseEntity
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse)
    }

    // 클래스 내부에 있는 ExceptionHandler는 해당 컨트롤러 내에서 발생하는 Exception만 처리한다.
    @ExceptionHandler(value = [IndexOutOfBoundsException::class])
    fun indexOutOfBoundsException(): ResponseEntity<String> {
        println("controller exception handler")
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Index Error")
    }
}

/**
 * GET 요청 error response
{
    "result_code": "FAIL",
    "http_status": "400",
    "http_method": "GET",
    "message": "요청에 에러가 발생했습니다.",
    "path": "/api/exception",
    "timestamp": "2022-11-02T20:58:31.996252",
    "errors": [
    {
        "field": "age",
        "message": "10 이상이어야 합니다",
        "value": 2
    },
    {
        "field": "name",
        "message": "크기가 2에서 6 사이여야 합니다",
        "value": "solariiiiiiii"
    }
    ]
}
*/

/**
 * POST 요청 error response
{
    "result_code": "FAIL",
    "http_status": "400",
    "http_method": "POST",
    "message": "요청에 에러가 발생했습니다.",
    "path": "/api/exception",
    "timestamp": "2022-11-02T21:10:26.979374",
    "errors": [
    {
        "field": "createdAt",
        "message": "패턴이 올바르지 않습니다.",
        "value": "2022-11-02 13:00"
    },
    {
        "field": "age",
        "message": "0 이상이어야 합니다",
        "value": -2
    },
    {
        "field": "email",
        "message": "올바른 형식의 이메일 주소여야 합니다",
        "value": "solar@ test.com"
    },
    {
        "field": "name",
        "message": "크기가 2에서 8 사이여야 합니다",
        "value": "solariiiiiii"
    }
    ]
}
*/
