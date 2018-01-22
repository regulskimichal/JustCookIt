package pwr.po.global.configuration

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer
import pwr.po.domain.model.user.UserDetailsService

@Configuration
@EnableAuthorizationServer
class OAuth2AuthenticationConfig(
        private val userDetailsService: UserDetailsService,
        private val passwordEncoder: PasswordEncoder
) : GlobalAuthenticationConfigurerAdapter() {

    override fun init(auth: AuthenticationManagerBuilder) {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder)
    }


}
