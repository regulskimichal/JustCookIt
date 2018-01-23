package pwr.po.domain.model.recipe

import org.springframework.data.rest.core.annotation.RestResource
import java.time.LocalTime
import javax.persistence.*

@Entity
data class Stage(
        @Id
        @GeneratedValue
        val id: Long = 0,

        val number: Long,

        val name: String,

        val description: String,

        val cyclical: Boolean,

        val length: LocalTime,

        @ManyToOne
        @JoinColumn(name = "recipe_id")
        @RestResource(exported = false)
        val recipe: Recipe
)
