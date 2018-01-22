package pwr.po.domain.model.user

data class UserBasicInfoDto(
        val id: Long,
        val email: String,
        val name: String,
        val lastName: String,
        val username: String
)