package dev.solar.todo.service

import dev.solar.todo.database.Todo
import dev.solar.todo.database.convertTodo
import dev.solar.todo.model.http.TodoDto
import dev.solar.todo.model.http.convertTodoDto
import dev.solar.todo.repository.TodoRepositoryImpl
import org.springframework.stereotype.Service

/**
 * model mapper
 */
@Service
class TodoService(
    val todoRepositoryImpl: TodoRepositoryImpl
) {

    fun create(todoDto: TodoDto): TodoDto? {
        return todoDto.let {
            Todo().convertTodo(it)
        }.let {
            todoRepositoryImpl.save(it)
        }?.let {
            TodoDto().convertTodoDto(it)
        }
    }

    fun read(index: Int): TodoDto? {
        return todoRepositoryImpl.findOne(index)?.let {
            TodoDto().convertTodoDto(it)
        }
    }

    fun readAll(): MutableList<TodoDto> {
        return todoRepositoryImpl.findAll()
            .map {
                TodoDto().convertTodoDto(it)
            }.toMutableList()
    }

    fun update(todoDto: TodoDto): TodoDto? {
        return todoDto.let {
            Todo().convertTodo(it)
        }.let {
            todoRepositoryImpl.save(it)
        }?.let {
            TodoDto().convertTodoDto(it)
        }
    }

    fun delete(index: Int): Boolean {
        return todoRepositoryImpl.delete(index)
    }

}
