package demo.todo.adapter.`in`.web.request

import demo.todo.application.port.`in`.UpdateTodoUseCase

data class UpdateTodoRequest(
    val title: String,
    val description: String,
) {
    fun toCommand(
        id: String,
        author: String,
    ): UpdateTodoUseCase.Command =
        UpdateTodoUseCase.Command(
            id = id,
            title = title,
            description = description,
            author = author,
        )
}
