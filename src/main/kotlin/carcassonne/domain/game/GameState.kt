package carcassonne.domain.game

import carcassonne.domain.player.Player
import carcassonne.domain.tile.Tile

data class GameState (
    val tiles: List<Tile>,
    val turnNumber: Int,
    val player: Player
)
