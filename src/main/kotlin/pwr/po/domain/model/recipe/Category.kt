package pwr.po.domain.model.recipe

import javax.persistence.*

@Entity
data class Category(
        @Id
        @GeneratedValue
        val id: Long,

        val name: String,

        @ManyToOne(cascade = [CascadeType.ALL])
        @JoinColumn(name = "parent_id")
        val parent: Category?
)
