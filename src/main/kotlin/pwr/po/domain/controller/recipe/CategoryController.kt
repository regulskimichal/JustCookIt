package pwr.po.domain.controller.recipe

import io.swagger.annotations.ApiOperation
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import pwr.po.domain.model.recipe.Category

@RestController
@RequestMapping("/api/v1/category")
class CategoryController(
        private val categoryService: CategoryService
) {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(
            value = "\${swagger-config.CategoryController.findCategories.value}",
            notes = "\${swagger-config.CategoryController.findCategories.notes}"
    )
    internal fun findCategories(): List<Category> = categoryService.findAll()
}