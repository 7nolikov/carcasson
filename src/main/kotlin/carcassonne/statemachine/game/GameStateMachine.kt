package carcassonne.statemachine.game

import com.tinder.StateMachine
import org.slf4j.Logger

val logger: Logger? = null

sealed class State {
    object Initialized : State()
    object InProgress : State()
    object Finished : State()
}

sealed class Event {
    object OnGameStart : Event()
    object OnGameFinish : Event()
    object OnSave : Event()
    object OnClose : Event()
}

sealed class SideEffect {
    object LogGameStart : SideEffect()
    object LogGameFinish : SideEffect()
    object LogSave : SideEffect()
    object LogClose : SideEffect()
}

object GameStateMachineFactory {
    fun getInstance(): StateMachine<State, Event, SideEffect> {
        return StateMachine.create {
            initialState(State.Initialized)

            state<State.Initialized> {
                on<Event.OnGameStart> {
                    transitionTo(State.InProgress, SideEffect.LogGameStart)
                }
                on<Event.OnClose> {
                    transitionTo(State.Finished, SideEffect.LogClose)
                }
            }

            state<State.InProgress> {
                on<Event.OnGameFinish> {
                    transitionTo(State.Finished, SideEffect.LogGameFinish)
                }
                on<Event.OnSave> {
                    transitionTo(State.InProgress, SideEffect.LogSave)
                }
                on<Event.OnClose> {
                    transitionTo(State.Finished, SideEffect.LogClose)
                }
            }
            
            onTransition {
                val validTransition = it as? StateMachine.Transition.Valid ?: return@onTransition
                when (validTransition.sideEffect) {
                    SideEffect.LogGameStart -> logger?.debug(GAME_START_MESSAGE)
                    SideEffect.LogGameFinish -> logger?.debug(GAME_FINISH_MESSAGE)
                    SideEffect.LogSave -> logger?.debug(GAME_SAVE_MESSAGE)
                    SideEffect.LogClose -> logger?.debug(GAME_CLOSE_MESSAGE)
                }
            }
        }
    }
}

const val GAME_START_MESSAGE = "Game state : GAME STARTED"
const val GAME_FINISH_MESSAGE = "Game state : GAME FINISHED"
const val GAME_SAVE_MESSAGE = "Game state : GAME SAVED"
const val GAME_CLOSE_MESSAGE = "Game state : GAME CLOSED"
