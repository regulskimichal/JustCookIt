package pwr.po.global.exception.domain

class DomainException : RuntimeException {

    private val errorCode: DomainErrorCode

    private constructor(errorCode: DomainErrorCode, message: String, cause: Throwable) : super(message, cause) {
        this.errorCode = errorCode
    }

    private constructor(errorCode: DomainErrorCode, cause: Throwable) : super(cause) {
        this.errorCode = errorCode
    }

    private constructor(errorCode: DomainErrorCode) : super() {
        this.errorCode = errorCode
    }

    companion object {
        fun of(errorCode: DomainErrorCode, message: String, cause: Throwable) = DomainException(errorCode, message, cause)

        fun of(errorCode: DomainErrorCode, cause: Throwable) = DomainException(errorCode, cause)

        fun of(errorCode: DomainErrorCode) = DomainException(errorCode)
    }
}