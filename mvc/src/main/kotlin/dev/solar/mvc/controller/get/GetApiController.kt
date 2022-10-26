package dev.solar.mvc.controller.get

import dev.solar.mvc.model.http.UserRequest
import org.springframework.web.bind.annotation.*

@RestController // REST API Controller 동장
@RequestMapping("/api") // http://localhost:8080/api
class GetApiController {

    //현재 방식
    @GetMapping("/hello") // GET http://localhost:8080/api/hello
//    @GetMapping(path = ["/hello", "/abc"]) // GET http://localhost:8080/api/hello, GET http://localhost:8080/api/abc
    fun hello(): String {
        return "hello kotlin"
    }

    //이전 방식
//    @RequestMapping("request-mapping") //HTTP Method에 상관없이 동작한다. GET, POST ...
    @RequestMapping(method = [RequestMethod.GET], path = ["/request-mapping"]) //method : 요청을 허락할 HTTP Method를 제한한다. GET, POST ..., path : 경로 지정
    fun requestMapping(): String {
        return "request mapping"
    }

    //Path Variable
    @GetMapping("/get-mapping/path-variable/{name}/{age}") //GET http://localhost:8080/api/get-mapping/path-variable/solar/30
    fun pathVariable(@PathVariable name: String, @PathVariable age: Int): String { //pathVariable명과 동일한 변수명을 사용하면 자동매칭 된다. , age: 문자열->숫자로 캐스팅이 불가능한 값이 들어오면 에러가 발생
        println("$name, $age") //solar, 30
        return "$name, $age"
    }

    //파리미터명과 내부 변수명이 동일한 경우
    @GetMapping("/get-mapping/path-variable2/{name}/{age}") //GET http://localhost:8080/api/get-mapping/path-variable/solar/30
    fun pathVariable2(@PathVariable(value = "name") _name: String, @PathVariable(name = "age") age: Int): String { //value, name : 매칭할 pathVariable 속성명을 지정해주면 된다.
        val name = "kotlin"

        println("$_name, $age, $name") //solar, 30, kotlin
        return "$_name, $age"
    }

    //Query Parameter
    //컬렉션을 필터링하는 용도로 사용
    //Pagination을 위해서 사용
    @GetMapping("/get-mapping/query-param") //?name=solar&age=30
    fun queryParam(@RequestParam name: String, @RequestParam(value = "age") age: Int): String {
        println("$name , $age")
        return "$name $age"
    }

    //Query Parameter를 객체로 매핑
    //name, age, address, email 정보를 받아야할 경우, 4개의 파라미터로 받을 수 있지만 객체로 한번에 받을 수 있다.
    //변수명과 동일한 key명으로 매칭된다.
    //주소 url 패턴에는 하이픈(-)을 쓸 수 없다. 코틀린은 변수명에 하이픈(-)을 넣을 수 없다.
    //ex) phoneNumber -> phonenumber, phone-number과 같이 하이픈이 들어가면 object로 받을 수 없다. @RequestParam(value = "phone-number")과 같이 value로 지정해줘야 받을 수 있다.
    @GetMapping("/get-mapping/query-param/object")
    fun queryParamObject(userRequest: UserRequest): UserRequest { //@RestController로 선언하면 리턴 타입이 Object이면 JSON형태로 자동으로 변환된다. (ObjectMapper를 이용)
        println(userRequest) //UserRequest(name=solar, age=30, email=solar@naver.com, address=address)
        return userRequest
    }

    //Map 형태의 파라미터 받기
    //하이픈(-)이 들어가도 받을 수 있다.
    @GetMapping("/get-mapping/query-param/map")
    fun queryParamMap(@RequestParam map: Map<String, Any>): Map<String, Any> {
        println(map) //{name=solar, age=30, email=solar@naver.com, address=address, phone-number=010-1111-2222}
        val phoneNumber = map.get("phoone-number")
        println("phoneNumber is $phoneNumber")
        return map
    }

}
