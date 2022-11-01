package dev.solar.mvc.controller.put

import dev.solar.mvc.model.http.Result
import dev.solar.mvc.model.http.UserRequest
import dev.solar.mvc.model.http.UserResponse
import org.springframework.web.bind.annotation.*

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
    fun putMappingObject(@RequestBody userRequest: UserRequest): UserResponse {
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
    }
}
