package pwr.po.domain.model.recipe

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import pwr.po.domain.model.recipe.Category
import pwr.po.domain.model.recipe.Recipe

@Repository
interface RecipeRepository : JpaRepository<Recipe, Long> {

    fun findRecipesByNameAndUserId(name: String, userId: Long?): List<Recipe>

    fun findRecipesByNameAndUserIdIsNull(name: String): List<Recipe>
}