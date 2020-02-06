package carcassonne.statemachine.room

import com.tinder.StateMachine
import org.slf4j.Logger

val logger: Logger? = null

sealed class State {
    object NotExist : State()
    object Initialized : State()
    object Ready : State()
}

sealed class Event {
    object OnCreate : Event()
    object OnLoad : Event()
    object OnSettingsSet : Event()
    object OnGameStarted: Event()
    object OnClose : Event()
}

sealed class SideEffect {
    object LogCreate : SideEffect()
    object LogLoad : SideEffect()
    object LogSettingsSet : SideEffect()
    object LogGameStarted : SideEffect()
    object LogClose : SideEffect()
}

object RoomStateMachineFactory {
    fun getInstance(): StateMachine<State, Event, SideEffect> {
        return StateMachine.create {
            initialState(State.NotExist)

            state<State.NotExist> {
                on<Event.OnCreate> {
                    transitionTo(State.Initialized, SideEffect.LogCreate)
                }
                on<Event.OnLoad> {
                    transitionTo(State.Initialized, SideEffect.LogLoad)
                }
            }

            state<State.Initialized> {
                on<Event.OnSettingsSet> {
                    transitionTo(State.Ready, SideEffect.LogSettingsSet)
                }
                on<Event.OnClose> {
                    transitionTo(State.NotExist, SideEffect.LogClose)
                }
            }

            state<State.Ready> {
                on<Event.OnGameStarted> {
                    transitionTo(State.NotExist, SideEffect.LogGameStarted)
                }
                on<Event.OnClose> {
                    transitionTo(State.NotExist, SideEffect.LogClose)
                }
            }

            onTransition {
                val validTransition = it as? StateMachine.Transition.Valid ?: return@onTransition
                when (validTransition.sideEffect) {
                    SideEffect.LogCreate -> logger?.debug(ROOM_CREATED_MESSAGE)
                    SideEffect.LogLoad -> logger?.debug(ROOM_LOADED_MESSAGE)
                    SideEffect.LogSettingsSet -> logger?.debug(ROOM_SETTINGS_SET_MESSAGE)
                    SideEffect.LogGameStarted -> logger?.debug(ROOM_GAME_STARTED_MESSAGE)
                    SideEffect.LogClose -> logger?.debug(ROOM_CLOSED_MESSAGE)
                }
            }
        }
    }
}

const val ROOM_CREATED_MESSAGE = "Room state : ROOM CREATED"
const val ROOM_LOADED_MESSAGE = "Room state : ROOM LOADED"
const val ROOM_SETTINGS_SET_MESSAGE = "Room state : SETTINGS SET"
const val ROOM_GAME_STARTED_MESSAGE = "Room state : GAME STARTED"
const val ROOM_CLOSED_MESSAGE = "Room state : ROOM CLOSED"
