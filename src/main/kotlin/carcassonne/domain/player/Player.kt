package carcassonne.domain.player

import carcassonne.domain.meeple.Meeple
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
data class Player (
    @Id
    val name: String,
    val email: String,
    val password: String,
    @OneToMany
    val meeples: List<Meeple>,
    val score: Int
)
