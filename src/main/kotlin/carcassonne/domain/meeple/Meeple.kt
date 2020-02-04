package carcassonne.domain.meeple

import carcassonne.domain.player.Player
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
data class Meeple (
    @Id
    @GeneratedValue
    val id: Long,
    val type: MeepleType,
    @ManyToOne
    val player: Player
)
