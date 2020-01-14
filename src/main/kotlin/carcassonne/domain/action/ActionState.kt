package carcassonne.domain.action

import carcassonne.domain.player.Player

data class ActionState (
    val player: Player,
    val actions: List<PlayerAction>,
    val actionAllowed: Boolean
)
