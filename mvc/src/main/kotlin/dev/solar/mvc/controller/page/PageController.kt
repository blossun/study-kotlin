package dev.solar.mvc.controller.page

import dev.solar.mvc.model.http.UserRequest
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

// @Controller를 쓰면 return에 해당하는 파일을 static 디렉토리 하위에서 찾아서 반환한다.
@Controller
class PageController {
    @GetMapping("/main")
    fun main(): String {
        println("init main")
        return "main.html"
    }

    @ResponseBody //이 어노테이션을 붙여주면 json 형태로 반환한다.
    @RequestMapping("/test")
    fun response(): UserRequest {
        return UserRequest().apply {
            this.name = "solar"
        }
//        return "main.html"
    }
}
