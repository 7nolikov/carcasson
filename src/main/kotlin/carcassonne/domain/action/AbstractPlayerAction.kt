package carcassonne.domain.action

import java.util.*

abstract class AbstractPlayerAction<T>: PlayerAction {
    var options = Collections.emptySet<T>()
}

