package carcassonne.statemachine.auth

import com.tinder.StateMachine
import org.slf4j.Logger

val logger: Logger? = null

sealed class State {
    object NotLogged : State()
    object Logged : State()
    object PendingVerification : State()
    object PasswordReset : State()
}

sealed class Event {
    object OnLogin : Event()
    object OnRegister : Event()
    object OnVerificationCodeAccepted : Event()
    object OnLogout : Event()
    object OnPasswordReset : Event()
}

sealed class SideEffect {
    object LogNotLogged : SideEffect()
    object LogLogged : SideEffect()
    object LogPendingVerification : SideEffect()
    object LogPasswordReset : SideEffect()
}

object AuthStateMachineFactory {
    fun getInstance(): StateMachine<State, Event, SideEffect> {
        return StateMachine.create {
            initialState(State.NotLogged)

            state<State.NotLogged> {
                on<Event.OnLogin> {
                    transitionTo(State.Logged, SideEffect.LogLogged)
                }

                on<Event.OnRegister> {
                    transitionTo(State.PendingVerification, SideEffect.LogPendingVerification)
                }

                on<Event.OnPasswordReset> {
                    transitionTo(State.PasswordReset, SideEffect.LogPasswordReset)
                }
            }

            state<State.PendingVerification> {
                on<Event.OnVerificationCodeAccepted> {
                    transitionTo(State.Logged, SideEffect.LogLogged)
                }
            }

            state<State.Logged> {
                on<Event.OnLogout> {
                    transitionTo(State.NotLogged, SideEffect.LogNotLogged)
                }
            }

            state<State.PasswordReset> {
                on<Event.OnVerificationCodeAccepted> {
                    transitionTo(State.Logged, SideEffect.LogLogged)
                }
            }

            onTransition {
                val validTransition = it as? StateMachine.Transition.Valid ?: return@onTransition
                when (validTransition.sideEffect) {
                    SideEffect.LogNotLogged -> logger?.debug(NOT_LOGGED_MESSAGE)
                    SideEffect.LogLogged -> logger?.debug(LOGGED_MESSAGE)
                    SideEffect.LogPendingVerification -> logger?.debug(PENDING_VERIFICATION_MESSAGE)
                    SideEffect.LogPasswordReset -> logger?.debug(PASSWORD_RESET_MESSAGE)
                }
            }
        }
    }
}

const val NOT_LOGGED_MESSAGE = "User state : NOT LOGGED"
const val LOGGED_MESSAGE = "User state : LOGGED"
const val PENDING_VERIFICATION_MESSAGE = "User state : PENDING VERIFICATION"
const val PASSWORD_RESET_MESSAGE = "User state : PASSWORD RESET"
