package pwr.po.domain.controller.recipe

import io.swagger.annotations.ApiOperation
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import pwr.po.domain.model.recipe.CreateRecipeDto
import pwr.po.domain.model.recipe.FindRecipeDto
import pwr.po.domain.model.recipe.Recipe
import pwr.po.domain.model.recipe.RecipeMapper
import javax.validation.Valid

@RestController
@RequestMapping("/api/v1/recipe")
class PublicRecipeController(
        private val recipeService: RecipeService,
        private val recipeMapper: RecipeMapper
) {
    @PostMapping
    @ResponseStatus(HttpStatus.FOUND)
    @ApiOperation(
            value = "\${swagger-config.PublicRecipeController.findRecipe.value}",
            notes = "\${swagger-config.PublicRecipeController.findRecipe.notes}"
    )
    internal fun findRecipe(@RequestBody @Valid findRecipeDto: FindRecipeDto): List<Recipe> =
            recipeService.findRecipeByNameAndUserIsNull(findRecipeDto.name)

    @PutMapping
    @ApiOperation(
            value = "\${swagger-config.PublicRecipeController.createRecipe.value}",
            notes = "\${swagger-config.PublicRecipeController.createRecipe.notes}"
    )
    internal fun createRecipe(@RequestBody @Valid createRecipeDto: CreateRecipeDto): Recipe = recipeService.createRecipe(
            recipeMapper.toRecipe(createRecipeDto)
    )
}