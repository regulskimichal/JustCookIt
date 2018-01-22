package pwr.po.domain.model.recipe

import java.time.LocalTime
import javax.persistence.*

@Entity
data class Stage(
        @Id
        @GeneratedValue
        val id: Long = 0,

        val name: String,

        val description: String,

        val cyclical: Boolean,

        val length: LocalTime,

        @ManyToOne
        @JoinColumn(name = "recipe_id")
        val recipe: Recipe
)
