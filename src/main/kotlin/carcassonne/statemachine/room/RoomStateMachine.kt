package carcassonne.statemachine.room

sealed class State {
    object RoomListInitialized : State()
    object RoomListFetched : State()
    object RoomCreated : State()
    object RoomUpdated : State()
    object RoomDeleted : State()
}

sealed class Event {
    object OnLogin : Event()
    object OnRegister : Event()
    object OnLogout : Event()
    object OnPasswordReset : Event()
}

sealed class SideEffect {
    object LogMelted : SideEffect()
    object LogFrozen : SideEffect()
    object LogVaporized : SideEffect()
    object LogCondensed : SideEffect()
}
