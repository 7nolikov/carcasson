package carcassonne.client

import feign.RequestLine
import org.springframework.cloud.openfeign.FeignClient

@FeignClient("auth")
interface AuthClient {

    @RequestLine("POST /login")
    fun login(username: String, password: String)

    @RequestLine("POST /register")
    fun register()

    @RequestLine("POST /logout")
    fun logout()

    @RequestLine("POST /reset-password")
    fun resetPassword()
}
