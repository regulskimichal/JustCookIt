package pwr.po.domain.model.user

import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component
import pwr.po.domain.controller.user.UserService

@Component
class UserMapper(
        private val passwordEncoder: PasswordEncoder,
        private val userService: UserService
) {

    fun toUser(createUserDto: CreateUserDto): User = User(
            username = createUserDto.username,
            password = passwordEncoder.encode(createUserDto.password),
            email = createUserDto.email,
            name = createUserDto.name,
            lastName = createUserDto.lastName
    )

    fun toUser(id: Long) = userService.findUserById(id)

    fun toUserBasicInfoDto(user: User): UserBasicInfoDto = UserBasicInfoDto(
            id = user.id,
            username = user.username,
            email = user.email,
            name = user.name,
            lastName = user.lastName
    )
}
