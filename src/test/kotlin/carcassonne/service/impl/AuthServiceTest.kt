package carcassonne.service.impl

import carcassonne.service.AuthService
import io.mockk.impl.annotations.InjectMockKs
import org.amshove.kluent.`should be`
import org.amshove.kluent.`should equal`
import org.junit.jupiter.api.Test

class AuthServiceTest {

    @InjectMockKs
    private lateinit var authService: AuthService

    @Test
    fun login() {
        val username = "Dmitriy Novikov"
        val password = "mysecretpassword"
        val expectedToken = "12391"
        val token: String = authService.login(username, password)
        expectedToken `should equal` token
    }

    @Test
    fun logout() {
        val username = "joda"
        val logoutState = authService.logout(username)
        logoutState `should be` true
    }
}
