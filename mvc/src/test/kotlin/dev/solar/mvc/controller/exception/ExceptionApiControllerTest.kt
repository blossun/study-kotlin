package dev.solar.mvc.controller.exception

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import dev.solar.mvc.model.http.UserRequest
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.util.LinkedMultiValueMap

@WebMvcTest //모든 설정을 로드하지 않고 WebMvc 관련 기능만 로드한다.
@AutoConfigureMockMvc //자동으로 MockMvc 설정을 한다.
class ExceptionApiControllerTest {
    //mockMvc를 이용해서 가상의 request를 만든다.
    @Autowired
    lateinit var mockMvc: MockMvc

    @DisplayName("GET 요청이 정상적으로 응답이 오는지 확인")
    @Test
    fun helloTest() {
        mockMvc.perform(
            MockMvcRequestBuilders.get("/api/exception/hello")
        ).andExpect (
            MockMvcResultMatchers.status().isOk
        ).andExpect (
            MockMvcResultMatchers.content().string("hello")
        ).andDo(MockMvcResultHandlers.print())
    }

    @Test
    fun getTest() {
        val queryParams = LinkedMultiValueMap<String, String>()
        queryParams.add("name", "solar")
        queryParams.add("age", "20")

        mockMvc.perform(
            MockMvcRequestBuilders.get("/api/exception").queryParams(queryParams)
        ).andExpect(
            MockMvcResultMatchers.status().isOk
        ).andExpect(
            MockMvcResultMatchers.content().string("solar 20")
        ).andDo(MockMvcResultHandlers.print())
    }

    @Test
    fun getFailTest() {
        val queryParams = LinkedMultiValueMap<String, String>()
        queryParams.add("name", "solar")
        queryParams.add("age", "9")

        mockMvc.perform(
            MockMvcRequestBuilders.get("/api/exception").queryParams(queryParams)
        ).andExpect(
            MockMvcResultMatchers.status().isBadRequest
        ).andExpect(
            MockMvcResultMatchers.content().contentType("application/json")
        ).andExpect(
            MockMvcResultMatchers.jsonPath("\$.result_code").value("FAIL") //josn key,value값 확인
        ).andExpect(
            MockMvcResultMatchers.jsonPath("\$.errors[0].field").value("age")
        ).andExpect(
            MockMvcResultMatchers.jsonPath("\$.errors[0].value").value("9")
        ).andDo(MockMvcResultHandlers.print())
    }

    @Test
    fun postTest() {
        val userRequest = UserRequest().apply {
            this.name = "solar"
            this.age = 11
            this.phoneNumber = "010-1111-2222"
            this.address = "서울 종로구"
            this.email = "solar@test.com"
            this.createdAt = "2022-11-02 13:00:00"
        }

        val json = jacksonObjectMapper().writeValueAsString(userRequest) //object -> json
        println(json)

        mockMvc.perform(
            MockMvcRequestBuilders.post("/api/exception")
                .content(json) //ojbect mapper을 이용해서 object -> json으로 넣어준다.
                .contentType("application/json") //json이라고 알려줘야함
                .accept("application/json")
        ).andExpect(
            MockMvcResultMatchers.status().isOk
        ).andExpect(
            MockMvcResultMatchers.jsonPath("\$.name").value("solar")
        ).andExpect(
            MockMvcResultMatchers.jsonPath("\$.age").value("11")
        ).andExpect(
            MockMvcResultMatchers.jsonPath("\$.email").value("solar@test.com")
        ).andDo(MockMvcResultHandlers.print())
    }

    @Test
    fun postFailTest() {
        val userRequest = UserRequest().apply {
            this.name = "solar"
            this.age = -1
            this.phoneNumber = "010-1111-2222"
            this.address = "서울 종로구"
            this.email = "solar@test.com"
            this.createdAt = "2022-11-02 13:00:00"
        }

        val json = jacksonObjectMapper().writeValueAsString(userRequest) //object -> json
        println(json)

        mockMvc.perform(
            MockMvcRequestBuilders.post("/api/exception")
                .content(json) //ojbect mapper을 이용해서 object -> json으로 넣어준다.
                .contentType("application/json") //json이라고 알려줘야함
                .accept("application/json")
        ).andExpect(
            MockMvcResultMatchers.status().`is`(400)
        ).andExpect(
            MockMvcResultMatchers.jsonPath("\$.result_code").value("FAIL") //josn key,value값 확인
        ).andExpect(
            MockMvcResultMatchers.jsonPath("\$.errors[0].field").value("age")
        ).andExpect(
            MockMvcResultMatchers.jsonPath("\$.errors[0].value").value("-1")
        ).andDo(MockMvcResultHandlers.print())
    }
}
