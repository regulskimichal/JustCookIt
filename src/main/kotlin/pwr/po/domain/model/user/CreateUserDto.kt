package pwr.po.domain.model.user

data class CreateUserDto(
        val username: String,

        val password: String,

        val email: String,

        val name: String,

        val lastName: String
)