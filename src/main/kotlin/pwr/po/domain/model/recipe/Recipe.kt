package pwr.po.domain.model.recipe

import pwr.po.domain.model.ingredient.Ingredient
import javax.persistence.*

@Entity
data class Recipe(
        @Id
        @GeneratedValue
        val id: Long = 0,

        val userId: Long? = null,

        val name: String,

        val description: String,

        @ManyToMany
        @JoinTable(name = "recipe_category",
                joinColumns = [JoinColumn(name = "recipe_id", referencedColumnName = "id")],
                inverseJoinColumns = [JoinColumn(name = "category_id", referencedColumnName = "id")])
        val categories: MutableList<Category>,

        @OneToMany(mappedBy = "recipe", cascade = [CascadeType.ALL])
        val ingredients: MutableList<Ingredient>,

        @OneToMany(mappedBy = "recipe", cascade = [CascadeType.ALL])
        val stages: MutableList<Stage>,

        @OneToMany(mappedBy = "recipe", cascade = [CascadeType.ALL])
        val photos: MutableList<Photo>,

        val notice: String
)
