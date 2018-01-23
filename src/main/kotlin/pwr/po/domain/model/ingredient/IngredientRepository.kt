package pwr.po.domain.model.ingredient

import org.springframework.data.jpa.repository.JpaRepository

interface IngredientRepository : JpaRepository<Ingredient, Long>
