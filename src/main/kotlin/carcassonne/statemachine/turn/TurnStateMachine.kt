package carcassonne.statemachine.turn

import com.tinder.StateMachine
import org.slf4j.Logger

val logger: Logger? = null

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
    object OnShowAvailablePlacement : Event()
    object OnShownPlacementPreview : Event()
    object OnRotateTile : Event()
    object OnPlaceTile : Event()
    object OnPlaceMeeple : Event()
    object OnScorePoints : Event()
    object OnConfirmEndTurn : Event()
}

sealed class SideEffect {
    object LogShowAvailablePlacement : SideEffect()
    object LogShownPlacementPreview : SideEffect()
    object LogRotateTile : SideEffect()
    object LogPlaceTile : SideEffect()
    object LogPlaceMeeple : SideEffect()
    object LogScorePoints : SideEffect()
    object LogConfirmEndTurn : SideEffect()
}

object TurnStateMachineFactory {
    fun getInstance(): StateMachine<State, Event, SideEffect> {
        return StateMachine.create {
            initialState(State.NextTileGenerated)

            state<State.NextTileGenerated> {
                on<Event.OnShowAvailablePlacement> {
                    transitionTo(State.AvailablePlacementShown, SideEffect.LogShowAvailablePlacement)
                }
            }

            state<State.AvailablePlacementShown> {
                on<Event.OnShownPlacementPreview> {
                    transitionTo(State.PlacementPreviewShown, SideEffect.LogShownPlacementPreview)
                }
            }

            state<State.PlacementPreviewShown> {
                on<Event.OnRotateTile> {
                    transitionTo(State.TileRotated, SideEffect.LogRotateTile)
                }
            }

            state<State.TileRotated> {
                on<Event.OnPlaceTile> {
                    transitionTo(State.TilePlaced, SideEffect.LogPlaceTile)
                }
            }

            state<State.TilePlaced> {
                on<Event.OnPlaceMeeple> {
                    transitionTo(State.MeeplePlaced, SideEffect.LogPlaceMeeple)
                }
            }

            state<State.MeeplePlaced> {
                on<Event.OnScorePoints> {
                    transitionTo(State.PointsScored, SideEffect.LogScorePoints)
                }
            }

            state<State.PointsScored> {
                on<Event.OnConfirmEndTurn> {
                    transitionTo(State.NextTileGenerated, SideEffect.LogConfirmEndTurn)
                }
            }



            onTransition {
                val validTransition = it as? StateMachine.Transition.Valid ?: return@onTransition
                when (validTransition.sideEffect) {
                    SideEffect.LogShowAvailablePlacement -> logger?.debug(TURN_SHOWN_AVAILABLE_PLACEMENT_MESSAGE)
                    SideEffect.LogShownPlacementPreview -> logger?.debug(TURN_SHOWN_PLACEMENT_PREVIEW_MESSAGE)
                    SideEffect.LogRotateTile -> logger?.debug(TURN_TILE_ROTATED)
                    SideEffect.LogPlaceTile -> logger?.debug(TURN_TILE_PLACED)
                    SideEffect.LogPlaceMeeple -> logger?.debug(TURN_MEEPLE_PLACED)
                    SideEffect.LogScorePoints -> logger?.debug(TURN_POINTS_SCORED)
                    SideEffect.LogConfirmEndTurn -> logger?.debug(TURN_END_TURN_CONFIRMED)
                }
            }
        }
    }
}

const val TURN_SHOWN_AVAILABLE_PLACEMENT_MESSAGE = "Turn state : AVAILABLE PLACEMENT SHOWN"
const val TURN_SHOWN_PLACEMENT_PREVIEW_MESSAGE = "Turn state : PLACEMENT PREVIEW SHOWN"
const val TURN_TILE_ROTATED = "Turn state : TILE ROTATED"
const val TURN_TILE_PLACED = "Turn state : TILE PLACED"
const val TURN_MEEPLE_PLACED = "Turn state : MEEPLE PLACED"
const val TURN_POINTS_SCORED = "Turn state : POINTS SCORED"
const val TURN_END_TURN_CONFIRMED = "Turn state : END TURN CONFIRMED"
