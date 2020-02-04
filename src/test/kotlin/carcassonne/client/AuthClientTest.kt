package carcassonne.client

import carcassonne.service.AuthService
import carcassonne.statemachine.auth.AuthStateMachineFactory
import carcassonne.statemachine.auth.State
import org.amshove.kluent.`should equal`
import org.amshove.kluent.`should not be`
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`

class AuthClientTest {

    @InjectMocks
    private lateinit var authClient: AuthClient

    @Mock
    private lateinit var authService: AuthService

    private val authStateMachine = AuthStateMachineFactory.getInstance()

    @Test
    fun testLogin() {
        `when`(authService.login(TEST_USERNAME, TEST_PASSWORD)).thenReturn(TEST_TOKEN)
        val token = authClient.login(TEST_USERNAME, TEST_PASSWORD)
        token `should not be` null
        token `should equal` TEST_TOKEN
        authStateMachine.state `should equal` State.Logged
    }

    @Test
    fun testRegister() {
        authClient.register()
    }

    @Test
    fun testLogout() {
        authClient.logout()
    }

    @Test
    fun testResetPassword() {
        authClient.resetPassword()
    }

    companion object {
        private const val TEST_USERNAME = "john"
        private const val TEST_PASSWORD = "mysecretpassword"
        private const val TEST_TOKEN = "mysecrettoken"
    }
}
