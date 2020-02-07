package carcassonne.repository

import carcassonne.domain.game.GameState
import org.springframework.data.jpa.repository.JpaRepository

interface GameStateRepository: JpaRepository<GameState, Long>
