package carcassonne.domain

data class GameState (
    val field: List<List<Tile>>,
    val tiles: List<Tile>,
    val turnNumber: Int,
    val playerScore: List<Int>,
    val players: List<Player>
)
