package dev.solar.mvc.model.http

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime

data class ErrorResponse(
    @field:JsonProperty("result_code")
    var resultCode: String? = null,
    @field:JsonProperty("http_status")
    var httpStatus: String? = null,
    @field:JsonProperty("http_method")
    var httpMethod: String? = null, //사용자가 요청한 http method
    var message: String? = null,
    var path: String? = null,
    var timestamp: LocalDateTime? = null,
    var errors : MutableList<Error>? = mutableListOf()
)

data class Error(
    var field: String ?= null,
    var message: String ?= null,
    var value: Any ?= null //사용자가 입력한 값 //Any 타입이어야 String, Int, Boolean 모두 가능
)
