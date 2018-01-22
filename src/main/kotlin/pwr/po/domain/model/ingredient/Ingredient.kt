package pwr.po.domain.model.ingredient

import pwr.po.domain.model.recipe.MeasurementUnit
import pwr.po.domain.model.recipe.Recipe
import javax.persistence.*

@Entity
@Table(name = "ingredient", schema = "public")
data class Ingredient(
        @Id
        @GeneratedValue
        val id: Long = 0,

        val name: String,

        val amount: Double,

        @OneToOne
        @JoinColumn(name = "measurement_unit_id")
        val measurementUnit: MeasurementUnit,

        val allergen: Boolean,

        val countOnce: Boolean,

        @ManyToOne
        @JoinColumn(name = "recipe_id")
        val recipe: Recipe
) {
    fun toUnit(measurementUnit: MeasurementUnit): Ingredient {
        if (this.measurementUnit.type != measurementUnit.type) {
            throw IllegalArgumentException()
        } else {
            return this.copy(amount = amount * measurementUnit.ratio, measurementUnit = measurementUnit)
        }
    }
}
