package pwr.po.domain.model.recipe

import org.springframework.stereotype.Component

@Component
class RecipeMapper {
    fun toRecipe(createRecipeDto: CreateRecipeDto) = Recipe(
            name = createRecipeDto.name,
            categories = createRecipeDto.categories.toMutableList(),
            description = createRecipeDto.description,
            ingredients = createRecipeDto.ingredients.toMutableList(),
            stages = createRecipeDto.stages.toMutableList(),
            photos = createRecipeDto.photos.toMutableList(),
            notice = createRecipeDto.notice
    )
}
