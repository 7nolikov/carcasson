package carcassonne.service

import carcassonne.domain.game.GameSettings

interface GameSettingsService {
    fun get(): GameSettings
    fun apply(settings: GameSettings): Boolean
    fun reset(): Boolean
}
