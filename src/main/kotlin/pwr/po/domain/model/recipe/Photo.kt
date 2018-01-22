package pwr.po.domain.model.recipe

import java.net.URI
import javax.persistence.*

@Entity
data class Photo(
        @Id
        @GeneratedValue
        val id: Long = 0,

        val uri: URI,

        @ManyToOne
        @JoinColumn(name = "recipe_id")
        val recipe: Recipe
)
