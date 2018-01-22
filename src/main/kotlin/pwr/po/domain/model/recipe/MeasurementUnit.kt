package pwr.po.domain.model.recipe

import pwr.po.domain.model.recipe.MeasurementUnitType.MASS
import pwr.po.domain.model.recipe.MeasurementUnitType.VOLUME
import pwr.po.domain.model.user.User
import javax.persistence.*

@Entity
@Table(name = "measurement_unit", schema = "public")
data class MeasurementUnit(
        @Id
        @GeneratedValue
        val id: Long = 0,

        val name: String,

        val abbreviation: String,

        val type: MeasurementUnitType,

        val ratio: Double,

        @ManyToOne
        @JoinColumn(name = "base_id")
        val baseUnit: MeasurementUnit? = null,

        @ManyToOne
        @JoinColumn(name = "user_id")
        val user: User? = null
) {

    companion object {
        val GRAM = MeasurementUnit(name = "gram", abbreviation = "g", type = MASS, ratio = 1.0)
        val MILLILITER = MeasurementUnit(name = "milliliter", abbreviation = "ml", type = VOLUME, ratio = 1.0)
        val UNIT = MeasurementUnit(name = "", abbreviation = "", type = MeasurementUnitType.UNIT, ratio = 1.0)
    }
}
