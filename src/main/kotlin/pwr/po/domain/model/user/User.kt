package pwr.po.domain.model.user

import pwr.po.domain.model.recipe.MeasurementUnit
import javax.persistence.*

@Entity
@Table(name = "user", schema = "public")
data class User(
        @Id
        @GeneratedValue
        val id: Long = 0,

        @Column(unique = true)
        val username: String,

        val password: String,

        @Column(unique = true)
        val email: String,

        val name: String,

        val lastName: String,

        val premium: Boolean = false,

        @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = [CascadeType.ALL])
        val measurementUnits: MutableList<MeasurementUnit> = mutableListOf(),

        @OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = [CascadeType.ALL])
        val roles: MutableList<Role> = mutableListOf()
)
