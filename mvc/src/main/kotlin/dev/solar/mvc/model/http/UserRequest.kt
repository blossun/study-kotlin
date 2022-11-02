package dev.solar.mvc.model.http

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import javax.validation.constraints.*

//@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class) //방법2. json 네이밍이 스네이크케이스라는 것을 클래스에 명시한다.
data class UserRequest(

    @field:NotEmpty
    @field:Size(min = 2, max = 8)
    var name: String? = null,

    @field:PositiveOrZero // 0 < 숫자를 검증 (0,양수)
    var age: Int? = null,

    @field:Email    // email 양식
    var email: String? = null,

    @field:NotBlank // 공백 검증
    var address: String? = null,

    //@JsonProperty("phone_number") //방법1. 코틀린에서 변수의 json 네이밍을 알려준다.
    @field:Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}\$") // 정규표현식 검증
    var phoneNumber: String? = null //kotlin은 변수명을 카멜케이스를 컨벤션으로한다. 반면 rest-api는 스네이크케이스로 넘어오는 경우가 많다. phone_number
)
