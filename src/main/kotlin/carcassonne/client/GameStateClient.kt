package carcassonne.client

import feign.RequestLine
import org.springframework.cloud.openfeign.FeignClient

@FeignClient("game-state")
interface GameStateClient {

    @RequestLine("POST /state/{username}")
    fun sendGameState()

    @RequestLine("GET /state/{username}")
    fun getGameState()
}
