package pwr.po.global.configuration

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter

@Configuration
@EnableResourceServer
class OAuth2ResourceServerConfig : ResourceServerConfigurerAdapter() {

    override fun configure(http: HttpSecurity) {
        http.cors().and()
                .authorizeRequests()
                .antMatchers("/", "/user/**", "/console/**", "/swagger-ui.html")
                .permitAll()
                .antMatchers("/emergency/**")
                .authenticated()
    }
}
