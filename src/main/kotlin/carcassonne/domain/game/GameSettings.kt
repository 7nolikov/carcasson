package carcassonne.domain.game

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
data class GameSettings (
    @Id
    val id: Long,
    @OneToMany
    val rules: List<Rule>
)
