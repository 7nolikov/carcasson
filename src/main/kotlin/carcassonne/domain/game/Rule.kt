package carcassonne.domain.game

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Rule (
    @Id
    @GeneratedValue
    val id: Long,
    val name: String
)
