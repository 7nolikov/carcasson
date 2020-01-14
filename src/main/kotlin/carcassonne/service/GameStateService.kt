package carcassonne.service

import carcassonne.domain.game.GameState

interface GameStateService {
    fun startGame(): GameState
    fun endGame()
    fun resetGame()
    fun makeTurn()
    fun sendEndTurnNotification()
    fun showScoreBoard()
}
