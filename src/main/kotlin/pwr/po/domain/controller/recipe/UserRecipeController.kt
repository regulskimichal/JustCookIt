package pwr.po.domain.controller.recipe

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import pwr.po.domain.controller.user.UserService

@RestController
@RequestMapping("/api/v1/{userId}/recipe")
class UserRecipeController(
        private val recipeService: RecipeService,
        private val userService: UserService
)
