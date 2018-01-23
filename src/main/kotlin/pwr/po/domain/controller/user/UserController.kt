package pwr.po.domain.controller.user

import io.swagger.annotations.ApiOperation
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import pwr.po.domain.model.user.CreateUserDto
import pwr.po.domain.model.user.UserBasicInfoDto
import pwr.po.domain.model.user.UserMapper
import javax.validation.Valid

@RestController
@RequestMapping("/api/v1/user")
class UserController(
        private val userService: UserService,
        private val userMapper: UserMapper
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(
            value = "\${swagger-config.UserController.createUser.value}",
            notes = "\${swagger-config.UserController.createUser.notes}"
    )
    internal fun createUser(@RequestBody @Valid createUserDto: CreateUserDto): UserBasicInfoDto {
        return userMapper.toUserBasicInfoDto(
                userService.createUser(
                        userMapper.toUser(createUserDto)
                )
        )
    }
}
