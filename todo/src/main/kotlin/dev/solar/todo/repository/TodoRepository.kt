package dev.solar.todo.repository

import dev.solar.todo.database.Todo

interface TodoRepository {

    // DB에서 기본적으로 제공해줘야하는 CRUD 메소드를 정의한다.
    fun save(todo: Todo): Todo? //jpa 동작과 마찬가지로 존재하지 않는 Todo이면 insert, 존재하는 Todo이면 update를 실행한다.
    fun saveAll(todoList: MutableList<Todo>): Boolean
    fun delete(index: Int): Boolean

    fun findOne(index: Int): Todo?
    fun findAll(): MutableList<Todo>
}
