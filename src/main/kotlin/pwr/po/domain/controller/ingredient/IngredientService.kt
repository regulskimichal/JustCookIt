package pwr.po.domain.controller.ingredient

import org.springframework.stereotype.Service
import pwr.po.domain.model.ingredient.IngredientRepository

@Service
class IngredientService(
        private val ingredientRepository: IngredientRepository
) {

}