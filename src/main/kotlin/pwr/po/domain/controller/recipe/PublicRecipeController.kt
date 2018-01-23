package pwr.po.domain.controller.recipe

import io.swagger.annotations.ApiOperation
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import pwr.po.domain.model.recipe.CreateRecipeDto
import pwr.po.domain.model.recipe.Recipe
import pwr.po.domain.model.recipe.RecipeMapper
import javax.validation.Valid

@RestController
@RequestMapping("/api/v1/recipe")
class PublicRecipeController(
        private val recipeService: RecipeService,
        private val recipeMapper: RecipeMapper
) {
    @GetMapping(params = ["name"])
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(
            value = "\${swagger-config.PublicRecipeController.findRecipesByName.value}",
            notes = "\${swagger-config.PublicRecipeController.findRecipesByName.notes}"
    )
    internal fun findRecipesByName(@RequestParam name: String): List<Recipe> = recipeService.findRecipesByNameLike(name)

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(
            value = "\${swagger-config.PublicRecipeController.findRecipes.value}",
            notes = "\${swagger-config.PublicRecipeController.findRecipes.notes}"
    )
    internal fun findRecipes(): List<Recipe> = recipeService.findAll()

    @PostMapping
    @ApiOperation(
            value = "\${swagger-config.PublicRecipeController.createRecipe.value}",
            notes = "\${swagger-config.PublicRecipeController.createRecipe.notes}"
    )
    internal fun createRecipe(@RequestBody @Valid createRecipeDto: CreateRecipeDto): Recipe = recipeService.createRecipe(
            recipeMapper.toRecipe(createRecipeDto)
    )
}