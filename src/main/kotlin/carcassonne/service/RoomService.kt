package carcassonne.service

import carcassonne.domain.room.Room

interface RoomService {
    fun create(): Room
    fun join(room: Room): Boolean
    fun delete(room: Room): Boolean
    fun getAll(): List<Room>
}
