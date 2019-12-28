package carcassonne.domain

import carcassonne.domain.action.PlayerAction

data class ActionState (
    val player: Player,
    val actions: List<PlayerAction>,
    val actionAllowed: Boolean
)
