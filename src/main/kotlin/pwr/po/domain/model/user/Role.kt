package pwr.po.domain.model.user

import javax.persistence.*

@Entity
@Table(name = "role", schema = "public")
data class Role(
        @Id
        @GeneratedValue
        val id: Long = 0,

        val name: String,

        @ManyToOne(cascade = [CascadeType.ALL])
        @JoinColumn(name = "user_id")
        val user: User
)