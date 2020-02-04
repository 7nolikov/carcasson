package carcassonne.domain.tile

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Tile (
    @Id
    @GeneratedValue
    val id: Long,
    val image: String
)
