package dev.solar.todo.repository

import dev.solar.todo.database.Todo
import dev.solar.todo.database.TodoDataBase
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.lang.Exception
import java.time.LocalDateTime

@Service
class TodoRepositoryImpl : TodoRepository {

    @Autowired
    lateinit var todoDataBase: TodoDataBase //DB를 자동주입 받는다.

    override fun save(todo: Todo): Todo? {

        // jpa 동작과 마찬가지로 존재하지 않는 Todo이면 insert, 존재하는 Todo이면 update를 실행한다.
        // 1. index가 있는지 확인
        return todo.index?.let { index ->
            // 존재하면 update
            findOne(index)?.apply { //todo를 찾아온다.
                this.title = todo.title
                this.description = todo.description
                this.schedule = todo.schedule
                this.updatedAt = LocalDateTime.now()
            }
        } ?: kotlin.run {
            // 존재하지 않으면 insert
            todo.apply {
                this.index = ++todoDataBase.index
                this.createdAt = LocalDateTime.now()
                this.updatedAt = LocalDateTime.now()
            }.run {
                todoDataBase.todoList.add(todo)
                this
            }
        }

        // 코틀린 스럽게
//        return todo.apply {
//            this.index = ++todoDataBase.index
//            this.createdAt = LocalDateTime.now()
//            this.updatedAt = LocalDateTime.now()
//        }. run {
//            todoDataBase.todoList.add(todo)
//            this
//        }

        // 위 코드와 동일
//        val index = todoDataBase.index++
//        todo.index = index
//        todoDataBase.todoList.add(todo)
//        return todo
    }

    override fun saveAll(todoList: MutableList<Todo>): Boolean {
        return try {
            todoList.forEach {
                save(it)
            }
            true
        } catch (e: Exception) {
            false
        }
    }

    override fun delete(index: Int): Boolean {
        val todo = findOne(index)

        return todo?.let {
            todoDataBase.todoList.remove(it)
            true
        } ?: kotlin.run {
            false //없는 index라면 false를 반환
        }
    }

    override fun findOne(index: Int): Todo? {
        return todoDataBase.todoList.first { it.index == index }
    }

    override fun findAll(): MutableList<Todo> {
        return todoDataBase.todoList //이러면 mutable한게 반환돼서 위험한 거 아닌가?
    }
}
