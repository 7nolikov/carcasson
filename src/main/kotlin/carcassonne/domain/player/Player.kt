package carcassonne.domain.player

import carcassonne.domain.meeple.Meeple

data class Player (
    val name: String,
    val email: String,
    val password: String,
    val meeples: List<Meeple>,
    val score: Int
)
