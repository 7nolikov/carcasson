package carcassonne.service

import carcassonne.domain.GameSettings

interface GameSettingsService {
    fun get(): GameSettings
    fun apply(settings: GameSettings): Boolean
    fun reset(): Boolean
}
