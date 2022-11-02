package dev.solar.mvc.controller.put

import dev.solar.mvc.model.http.Result
import dev.solar.mvc.model.http.UserRequest
import dev.solar.mvc.model.http.UserResponse
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.validation.FieldError
import org.springframework.web.bind.annotation.*
import java.lang.StringBuilder
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class PutApiController {

    @PutMapping("/put-mapping")
    fun putMapping(): String {
        return "put-mapping"
    }

    @RequestMapping(method = [RequestMethod.PUT], path = ["/request-mapping"])
    fun requestMapping(): String {
        return "request-mapping - put method"
    }

    @PutMapping(path = ["/put-mapping/object"])
    fun putMappingObject(@Valid @RequestBody userRequest: UserRequest, bindingResult: BindingResult): ResponseEntity<String> { //@Valid 해당 빈(UserRequest)에 대해서 검증

        if (bindingResult.hasErrors()) {
            //500 error
            val msg = StringBuilder()
            bindingResult.allErrors.forEach {
                val field = it as FieldError
                val message = it.defaultMessage
                msg.append(field.field + " : " + message + "\n")
            }
            return ResponseEntity.badRequest().body(msg.toString())
        }

        return ResponseEntity.ok("")

        /*
        // 0. Response
        return UserResponse().apply {
            // 1. result
            // 코틀린 표준함수 apply
            this.result = Result().apply {
                this.resultCode = "OK"
                this.resultMessage = "성공"
            }
        }.apply {
            // 2. description
            this.description = "~~~~~~~~~~"
        }.apply {
            // 3. user mutable list
            val userList = mutableListOf<UserRequest>()
            userList.add(userRequest)
            userList.add(UserRequest().apply {
                this.name = "holar"
                this.age = 18
                this.email = "holar@test.com"
                this.address = "경기"
                this.phoneNumber = "010-2222-3333"
            })
            userList.add(UserRequest().apply {
                this.name = "kolar"
                this.age = 58
                this.email = "kolar@test.com"
                this.address = "부산"
                this.phoneNumber = "010-3333-4444"
            })

            this.userRequest = userList
        }
        */
    }
    /**
     * === validate 체크 response ===
     * validCreatedAt : 생성일자의 패턴은 yyyy-MM-dd HH:mm:ss 여야 합니다.
     * name : 크기가 2에서 8 사이여야 합니다
     * email : 올바른 형식의 이메일 주소여야 합니다
     * age : 0 이상이어야 합니다
     */
}
