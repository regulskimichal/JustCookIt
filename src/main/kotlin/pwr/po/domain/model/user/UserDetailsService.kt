package pwr.po.domain.model.user

import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import pwr.po.domain.controller.user.UserService

@Service
class UserDetailsService(
        val userService: UserService
) : UserDetailsService {

    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(username: String): UserDetails {
        val user = userService.findUserByUsername(username)
        return when {
            user != null -> UserDetails(user)
            else -> throw UsernameNotFoundException("Username $username not found")
        }
    }
}
