package pwr.po.domain.model.recipe

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CategoryRepository : JpaRepository<Category, Long> {
    fun findCategoryByName(name: String): Category
}
