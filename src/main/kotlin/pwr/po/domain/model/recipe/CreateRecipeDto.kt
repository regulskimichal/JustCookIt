package pwr.po.domain.model.recipe

import pwr.po.domain.model.ingredient.Ingredient

data class CreateRecipeDto(
        val name: String,

        val description: String,

        val categories: List<Category>,

        val ingredients: List<Ingredient>,

        val stages: List<Stage>,

        val photos: List<Photo>,

        val notice: String
)
