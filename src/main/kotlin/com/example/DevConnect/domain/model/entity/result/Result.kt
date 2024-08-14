sealed class OperationResult<out T, out E> {
    data class Success<out T>(val value: T) : OperationResult<T, Nothing>()
    data class Failure<out E>(val error: E) : OperationResult<Nothing, E>()

    companion object {
        // 成功時のファクトリーメソッド
        fun <T> success(value: T): OperationResult<T, Nothing> = Success(value)

        // 失敗時のファクトリーメソッド
        fun <E> failure(error: E): OperationResult<Nothing, E> = Failure(error)
    }
}
