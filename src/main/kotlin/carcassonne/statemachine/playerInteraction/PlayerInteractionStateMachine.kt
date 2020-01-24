package carcassonne.statemachine.playerInteraction

sealed class State {
    object Welcomed : State()
    object Registered : State()
    object Verified : State()
    object Logged : State()
    object RoomCreated : State()
    object RoomJoined : State()
    object RoomLoaded : State()
    object GameInProcess : State()
    object FinalScoreShown : State()
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
