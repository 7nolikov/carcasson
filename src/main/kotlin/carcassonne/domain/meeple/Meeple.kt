package carcassonne.domain.meeple

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Meeple (
    @Id
    @GeneratedValue
    val id: Long,
    val type: MeepleType
)
