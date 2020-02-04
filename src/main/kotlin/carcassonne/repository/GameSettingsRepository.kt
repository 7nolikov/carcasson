package carcassonne.repository

import carcassonne.domain.game.GameSettings
import org.springframework.data.jpa.repository.JpaRepository

interface GameSettingsRepository: JpaRepository<GameSettings, Long>
