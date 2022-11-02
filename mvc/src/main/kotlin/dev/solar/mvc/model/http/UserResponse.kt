package dev.solar.mvc.model.http

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming

data class UserResponse(
    var result: Result? = null,
    var description: String? = null,
    @JsonProperty("users")
    var userRequest: MutableList<UserRequest>? = null //또는, 변수명을 users라고 해도 동일하다.
)

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class Result(
    var resultCode: String? = null,         //result_code
    var resultMessage: String? = null   //result_message
)


/*
아래와 같은 형식의 response를 주도록 수정해보자
스네이크케이스와 카멜케이스가 섞여있다.
{
    "result" : {
        "result_code" : "OK",
        "result_message" : "성공"
    },
    "description" : "~~~~~~~",
    "users" : [
        {
            "name": "solar",
            "age": 28,
            "email": "solar@test.com",
            "address": "서울",
            "phoneNumber": "000-1111-2222"
        },
        {
            "name": "holar",
            "age": 18,
            "email": "holar@test.com",
            "address": "경기",
            "phoneNumber": "000-1111-2222"
        },
        {
            "name": "kolar",
            "age": 58,
            "email": "kolar@test.com",
            "address": "부산",
            "phoneNumber": "000-1111-2222"
        },

    ]
}
*/

