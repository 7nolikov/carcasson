package carcassonne.service

interface GameStateService {
    fun startGame()
    fun endGame()
    fun resetGame()
    fun makeTurn()
    fun sendEndTurnNotification()
    fun showScoreBoard()
}
