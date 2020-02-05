package carcassonne.client

import feign.RequestLine
import org.springframework.cloud.openfeign.FeignClient

@FeignClient("game-settings")
interface GameSettingsClient {

    @RequestLine("POST /settings/{username}")
    fun sendSettings()

    @RequestLine("GET /settings/{username}")
    fun getSettings()
}
