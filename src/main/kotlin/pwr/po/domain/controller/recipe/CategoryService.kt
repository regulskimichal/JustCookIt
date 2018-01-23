package pwr.po.domain.controller.recipe

import org.springframework.stereotype.Service
import pwr.po.domain.model.recipe.Category
import pwr.po.domain.model.recipe.CategoryRepository

@Service
class CategoryService(
        private val categoryRepository: CategoryRepository
) {

    fun findAll(): List<Category> = categoryRepository.findAll()
}