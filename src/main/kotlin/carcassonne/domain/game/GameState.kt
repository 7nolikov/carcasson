package carcassonne.domain.game

import carcassonne.domain.player.Player
import carcassonne.domain.tile.Tile
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
data class GameState (
    @Id
    @GeneratedValue
    val id: Long,
    @OneToMany
    val tiles: List<Tile>,
    val turnNumber: Int,
    @OneToMany
    val players: List<Player>
)
