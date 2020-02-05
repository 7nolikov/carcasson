package carcassonne.client

import feign.RequestLine
import org.springframework.cloud.openfeign.FeignClient

@FeignClient("rooms")
interface RoomClient {

    @RequestLine("POST /room/{username}")
    fun createRoom()

    @RequestLine("POST /room/{username}")
    fun joinRoom()

    @RequestLine("GET /room")
    fun getAllRooms()

    @RequestLine("GET /room/{roomId}")
    fun getRoom()
}
