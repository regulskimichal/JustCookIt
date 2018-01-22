package pwr.po.domain.model.recipe

enum class MeasurementUnitType(
        val baseUnit: MeasurementUnit?
) {

    MASS(MeasurementUnit.GRAM),
    VOLUME(MeasurementUnit.MILLILITER),
    UNIT(MeasurementUnit.UNIT)
}
