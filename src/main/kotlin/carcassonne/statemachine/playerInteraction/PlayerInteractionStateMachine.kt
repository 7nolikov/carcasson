package carcassonne.statemachine.playerInteraction

import com.tinder.StateMachine
import org.slf4j.Logger

val logger: Logger? = null

sealed class State {
    object NotLogged : State()
    object RoomInteraction : State()
    object InRoom : State()
    object InGame : State()
    object InFinalScoreBoard : State()
}

sealed class Event {
    object OnLogin : Event()
    object OnLogout : Event()
    object OnRoomEnter : Event()
    object OnRoomExit : Event()
    object OnGameEnter : Event()
    object OnGameExit : Event()
    object OnFinalScoreBoardEnter : Event()
    object OnFinalScoreBoardExit : Event()
}

sealed class SideEffect {
    object LogLogin : SideEffect()
    object LogLogout : SideEffect()
    object LogRoomEnter : SideEffect()
    object LogRoomExit : SideEffect()
    object LogGameEnter : SideEffect()
    object LogGameExit : SideEffect()
    object LogFinalScoreBoardEnter : SideEffect()
    object LogFinalScoreBoardExit : SideEffect()
}

object AuthStateMachineFactory {
    fun getInstance(): StateMachine<State, Event, SideEffect> {
        return StateMachine.create {
            initialState(State.NotLogged)

            state<State.NotLogged> {
                on<Event.OnLogin> {
                    transitionTo(State.RoomInteraction, SideEffect.LogLogin)
                }
            }

            state<State.RoomInteraction> {
                on<Event.OnRoomEnter> {
                    transitionTo(State.InRoom, SideEffect.LogRoomEnter)
                }
                on<Event.OnLogout> {
                    transitionTo(State.NotLogged, SideEffect.LogLogout)
                }
            }

            state<State.InRoom> {
                on<Event.OnGameEnter> {
                    transitionTo(State.InGame, SideEffect.LogGameEnter)
                }
                on<Event.OnRoomExit> {
                    transitionTo(State.RoomInteraction, SideEffect.LogRoomExit)
                }
                on<Event.OnLogout> {
                    transitionTo(State.NotLogged, SideEffect.LogLogout)
                }
            }

            state<State.InGame> {
                on<Event.OnFinalScoreBoardEnter> {
                    transitionTo(State.InFinalScoreBoard, SideEffect.LogFinalScoreBoardEnter)
                }
                on<Event.OnGameExit> {
                    transitionTo(State.RoomInteraction, SideEffect.LogGameExit)
                }
                on<Event.OnLogout> {
                    transitionTo(State.NotLogged, SideEffect.LogLogout)
                }
            }

            state<State.InFinalScoreBoard> {
                on<Event.OnFinalScoreBoardExit> {
                    transitionTo(State.RoomInteraction, SideEffect.LogFinalScoreBoardExit)
                }
                on<Event.OnLogout> {
                    transitionTo(State.NotLogged, SideEffect.LogLogout)
                }
            }

            onTransition {
                val validTransition = it as? StateMachine.Transition.Valid ?: return@onTransition
                when (validTransition.sideEffect) {
                    SideEffect.LogLogin -> logger?.debug(LOGGED_MESSAGE)
                    SideEffect.LogLogout -> logger?.debug(NOT_LOGGED_MESSAGE)
                    SideEffect.LogRoomEnter -> logger?.debug(ROOM_ENTER_MESSAGE)
                    SideEffect.LogRoomExit -> logger?.debug(ROOM_EXIT_MESSAGE)
                    SideEffect.LogGameEnter -> logger?.debug(GAME_ENTER_MESSAGE)
                    SideEffect.LogGameExit -> logger?.debug(GAME_EXIT_MESSAGE)
                    SideEffect.LogFinalScoreBoardEnter -> logger?.debug(FINAL_SCORE_BOARD_ENTER_MESSAGE)
                    SideEffect.LogFinalScoreBoardExit -> logger?.debug(FINAL_SCORE_BOARD_EXIT_MESSAGE)
                }
            }
        }
    }
}

const val NOT_LOGGED_MESSAGE = "User interaction state : NOT LOGGED"
const val LOGGED_MESSAGE = "User interaction state : LOGGED"
const val ROOM_ENTER_MESSAGE = "User interaction state : IN ROOM"
const val ROOM_EXIT_MESSAGE = "User interaction state : LEFT ROOM"
const val GAME_ENTER_MESSAGE = "User interaction state : IN GAME"
const val GAME_EXIT_MESSAGE = "User interaction state : LEFT GAME "
const val FINAL_SCORE_BOARD_ENTER_MESSAGE = "User interaction state : IN FINAL SCORE BOARD"
const val FINAL_SCORE_BOARD_EXIT_MESSAGE = "User interaction state : LEFT FINAL SCORE BOARD"
