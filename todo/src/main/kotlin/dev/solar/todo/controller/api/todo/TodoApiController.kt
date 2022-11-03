package dev.solar.todo.controller.api.todo

import dev.solar.todo.model.http.TodoDto
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/todo")
@Validated
class TodoApiController {

    //Read
    @GetMapping
    fun read(@RequestParam(required = false) index: Int?) { //index가 있으면 단건 조회, 없으면 전체 조회

    }

    //Create
    @PostMapping
    fun create(@Valid @RequestBody todoDto: TodoDto) {

    }

    //Update
    @PutMapping
    fun update(@Valid @RequestBody todoDto: TodoDto) {

    }

    //Delete
    @DeleteMapping(path = ["/{index}"])
    fun delete(@PathVariable(name = "index") _index: Int) {

    }
}
