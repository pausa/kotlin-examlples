package k07_checked_exceptions

import mu.KotlinLogging

class ExceptionsKotlin {
    private val log = KotlinLogging.logger { }

    sealed interface MyResult

    data class CodedError(
        val code: Int,
        val mesasge: String
    ) : MyResult, Exception()

    data class OtherError(
        val other: String
    ) : MyResult, Exception()

    data class Success(
        val result: String
    ) : MyResult

    fun danger(): MyResult {
        TODO("some code that might explode")
    }

    fun example() {
        when (val out = danger()) {
            is Success -> log.info { out.result }
            is CodedError -> log.error { "${out.code} - ${out.message}" }
            is OtherError -> log.error { out.other }
        }
    }

}