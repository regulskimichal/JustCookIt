package pwr.po.domain.model.recipe

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RecipeRepository : JpaRepository<Recipe, Long> {

    fun findByIdAndUserIdIsNull(id: Long): List<Recipe>

    fun findByNameIgnoreCaseContaining(name: String): List<Recipe>
}