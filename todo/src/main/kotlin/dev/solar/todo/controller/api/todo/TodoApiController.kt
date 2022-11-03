package dev.solar.todo.controller.api.todo

import dev.solar.todo.model.http.TodoDto
import dev.solar.todo.service.TodoService
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/todos")
@Validated
class TodoApiController(
    val todoService: TodoService
) {

    //Read
    @GetMapping
    fun read(@RequestParam(required = false) index: Int?): ResponseEntity<Any?> {
        return index?.let {                 //index가 있으면 단건 조회
            todoService.read(it)
        }?.let {
            println("read $index => $it")
            return ResponseEntity.ok(it)
        } ?: kotlin.run {                   //index가 없으면 전체 조회하는 url로 리다이렉트 301 응답을 내려준다.
            return ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY).header(HttpHeaders.LOCATION, "/api/todos/all").build()
        }
    }

    //REST API 규칙을 따르진 않음... 예시를 위해서 만듦... 원래는 전체 조회는 /api/todos, 단건조회는 /api/todos/{index}로 만든다.
    @GetMapping("/all")
    fun readAll(): MutableList<TodoDto> {
        return todoService.readAll()
    }

    //TODO - ResponseEntity로 응답
    //Create
    @PostMapping
    fun create(@Valid @RequestBody todoDto: TodoDto): TodoDto? {
        return todoService.create(todoDto)
    }

    //Update - TODO: create -> 201, update -> 200 status가 나가도록 수정
    @PutMapping
    fun update(@Valid @RequestBody todoDto: TodoDto): TodoDto? {
        return todoService.create(todoDto)
    }

    //Delete
    @DeleteMapping(path = ["/{index}"])
    fun delete(@PathVariable(name = "index") _index: Int): ResponseEntity<Any> {
        if (!todoService.delete(_index)) {
            return ResponseEntity.status(500).build()
        }
        return ResponseEntity.ok().build()
    }
}
