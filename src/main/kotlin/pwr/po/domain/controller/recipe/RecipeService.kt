package pwr.po.domain.controller.recipe

import org.springframework.stereotype.Service
import pwr.po.domain.model.recipe.Recipe
import pwr.po.domain.model.recipe.RecipeRepository

@Service
class RecipeService(
        private val recipeRepository: RecipeRepository
) {

    fun createRecipe(recipe: Recipe): Recipe = recipeRepository.save(recipe)

    fun updateRecipe(recipe: Recipe): Recipe = recipeRepository.save(recipe)

    fun deleteRecipe(recipe: Recipe) = recipeRepository.delete(recipe)

    fun findRecipeByIdAndUserIsNull(id: Long): Recipe? = recipeRepository.getOne(id)

    fun findRecipesByNameLike(name: String): List<Recipe> = recipeRepository.findByNameIgnoreCaseContaining(name)

    fun findAll(): List<Recipe> = recipeRepository.findAll()
}
