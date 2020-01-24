package carcassonne.statemachine.turn

sealed class State {
    object NextTileGenerated : State()
    object AvailablePlacementShown : State()
    object PlacementPreviewShown : State()
    object TileRotated : State()
    object TilePlaced : State()
    object MeeplePlaced : State()
    object PointsScored : State()
}

sealed class Event {
    object OnMelted : Event()
    object OnFroze : Event()
    object OnVaporized : Event()
    object OnCondensed : Event()
}

sealed class SideEffect {
    object LogMelted : SideEffect()
    object LogFrozen : SideEffect()
    object LogVaporized : SideEffect()
    object LogCondensed : SideEffect()
}
