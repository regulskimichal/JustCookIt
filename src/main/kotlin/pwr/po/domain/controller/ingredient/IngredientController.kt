package pwr.po.domain.controller.ingredient

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/ingredient")
class IngredientController(
        private val ingredientService: IngredientService
) {

}