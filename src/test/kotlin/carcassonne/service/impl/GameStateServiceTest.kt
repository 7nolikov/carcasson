package carcassonne.service.impl

import carcassonne.domain.GameState
import carcassonne.service.GameStateService
import io.mockk.impl.annotations.InjectMockKs
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class GameStateServiceTest {

    @InjectMockKs
    private lateinit var gameStateService: GameStateService

    @BeforeEach
    internal fun setUp() {
        val initialGameState: GameState
        val updatedGameState: GameState
        val finalGameState: GameState
    }


    @Test
    fun startGame() {
        gameStateService.startGame()
    }
}
