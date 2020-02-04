package carcassonne.domain.room

import carcassonne.domain.game.GameSettings
import carcassonne.domain.player.Player

data class Room (
    val players: List<Player>,
    val settings: GameSettings
)
