package pwr.po.global.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.http.HttpHeaders
import org.springframework.util.AntPathMatcher
import pwr.po.domain.model.user.UserDetails
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.ParameterBuilder
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.schema.ModelRef
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.service.Parameter
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Configuration
@EnableSwagger2
@Profile("dev", "production")
class SwaggerConfig {

    private final val authorizationHeader: Parameter = ParameterBuilder()
            .name(HttpHeaders.AUTHORIZATION)
            .description("Header for authentication preceded by 'bearer' keyword.")
            .modelRef(ModelRef("string"))
            .parameterType(HEADER_PARAMETER_TYPE)
            .required(false)
            .build()

    private val globalOperationHeaders: List<Parameter> = listOf(authorizationHeader)

    @Bean
    internal fun api(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .globalOperationParameters(globalOperationHeaders)
                .ignoredParameterTypes(UserDetails::class.java)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(isEndpointForSwagger("/api/v1/**", "/oauth/token"))
                .build()
    }

    private fun apiInfo(): ApiInfo {
        return ApiInfoBuilder()
                .title("JustCookIt API")
                .version("0.1")
                .contact(
                        Contact("Michał Regulski",
                                "https://www.github.com/regulskimichal",
                                "regulskimichal@outlook.com")
                ).build()
    }

    fun isEndpointForSwagger(vararg antPattern: String): (String?) -> Boolean {
        return { input ->
            val matcher = AntPathMatcher()
            antPattern.any {
                input != null && matcher.match(it, input)
            }
        }
    }

    companion object {
        private val HEADER_PARAMETER_TYPE = "header"
    }
}
