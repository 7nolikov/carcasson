package carcassonne.service.impl

import carcassonne.domain.game.GameState
import carcassonne.domain.player.Player
import carcassonne.domain.tile.Tile
import carcassonne.service.GameStateService
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import org.amshove.kluent.`should equal`
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class GameStateServiceTest {

    @InjectMockKs
    private lateinit var gameStateService: GameStateService

    @MockK
    private lateinit var playerOne: Player
    @MockK
    private lateinit var playerTwo: Player
    @MockK
    private lateinit var playerThree: Player
    @MockK
    private lateinit var playerFour: Player
    @MockK
    private lateinit var tile: Tile

    @BeforeEach
    internal fun setUp() {
        val initialGameState: GameState
        val updatedGameState: GameState
        val finalGameState: GameState
    }

    @Test
    fun startGame() {
        val startGameState = gameStateService.startGame()

        startGameState.turnNumber `should equal` 1
    }
}
