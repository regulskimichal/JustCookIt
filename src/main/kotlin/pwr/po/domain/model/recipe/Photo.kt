package pwr.po.domain.model.recipe

import org.springframework.data.rest.core.annotation.RestResource
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
        @RestResource(exported = false)
        val recipe: Recipe
)
