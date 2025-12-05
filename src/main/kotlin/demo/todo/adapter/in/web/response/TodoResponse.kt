package demo.todo.adapter.`in`.web.response

import demo.todo.application.service.model.TodoReadModel

data class TodoResponse(
    val id: String,
    val title: String,
    val description: String,
    val author: String,
    val status: String,
) {
    companion object {
        fun from(todoReadModel: TodoReadModel): TodoResponse =
            TodoResponse(
                id = todoReadModel.id,
                title = todoReadModel.title,
                description = todoReadModel.description,
                author = todoReadModel.author,
                status = todoReadModel.status,
            )
    }
}
