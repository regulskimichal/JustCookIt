package pwr.po.domain.controller.user

import org.springframework.stereotype.Service
import pwr.po.domain.model.user.User
import pwr.po.domain.model.user.UserRepository

@Service
class UserService(
        private val userRepository: UserRepository
) {

    fun createUser(user: User): User = userRepository.save(user)

    fun updateUser(user: User): User = userRepository.save(user)

    fun deleteUser(user: User) = userRepository.delete(user)

    fun findUserById(id: Long): User = userRepository.getOne(id)

    fun findUserByUsername(username: String) : User? = userRepository.findByUsername(username)
}
