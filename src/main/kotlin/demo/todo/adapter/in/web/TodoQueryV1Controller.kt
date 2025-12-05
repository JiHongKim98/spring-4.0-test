package demo.todo.adapter.`in`.web

import demo.todo.adapter.`in`.web.response.TodoResponse
import demo.todo.application.port.`in`.ReadAllTodoUseCase
import demo.todo.application.port.`in`.ReadTodoUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/todos", version = "v1")
internal class TodoQueryV1Controller(
    private val readTodoUseCase: ReadTodoUseCase,
    private val readAllTodoUseCase: ReadAllTodoUseCase,
) {
    @GetMapping("/{id}")
    fun readTodo(
        @PathVariable id: String,
    ): ResponseEntity<TodoResponse> {
        val results = readTodoUseCase.execute(ReadTodoUseCase.Query(id))
        val response = TodoResponse.from(results)
        return ResponseEntity.ok(response)
    }

    @GetMapping
    fun readAllTodo(): ResponseEntity<List<TodoResponse>> {
        val results = readAllTodoUseCase.execute()
        val response = results.map { TodoResponse.from(it) }
        return ResponseEntity.ok(response)
    }
}
