package carcassonne.statemachine.auth

sealed class State {
    object NotLogged : State()
    object Logged : State()
    object PendingVerification : State()
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
