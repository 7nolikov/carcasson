package carcassonne.service

import carcassonne.domain.Tile
import java.awt.Point

interface TileService {
    fun getNextRandomTile(): Tile
    fun rotateTile(): Tile
    fun placeTile(tile: Tile, x: Int, y: Int): Boolean
    fun confirmTilePlacement()
    fun getAllOptions(tile: Tile): List<Point>
}
