package demo.todo.common.exception

/**
 * stacktrace 가 억제된 기본 예외 객체
 */
open class BaseSuppressedException(
    message: String,
    private val _type: Type,
) : RuntimeException(message, null, false, false) {
    val type: String
        get() = _type.value

    enum class Type(
        val value: String,
    ) {
        DOMAIN("도메인"),
        SERVICE("서비스"),
        INFRA("인프라"),
        API("api"),
    }
}
