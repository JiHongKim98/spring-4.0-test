package demo.todo.adapter.`in`.web.request

import demo.todo.application.port.`in`.CreateTodoUseCase

data class CreateTodoRequest(
    val title: String,
    val description: String,
) {
    fun toCommand(author: String): CreateTodoUseCase.Command =
        CreateTodoUseCase.Command(
            title = title,
            description = description,
            author = author,
        )
}
