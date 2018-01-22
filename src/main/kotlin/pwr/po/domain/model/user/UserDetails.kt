package pwr.po.domain.model.user

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

data class UserDetails(
        val user: User
) : UserDetails {

    private val authorities: MutableCollection<SimpleGrantedAuthority> = user.roles.map {
        SimpleGrantedAuthority(it.name.toUpperCase())
    }.toMutableList()

    override fun isEnabled(): Boolean = true

    override fun getUsername(): String = user.username

    override fun isCredentialsNonExpired(): Boolean = true

    override fun getPassword(): String = user.password

    override fun isAccountNonExpired(): Boolean = true

    override fun isAccountNonLocked(): Boolean = true

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> = authorities
}
