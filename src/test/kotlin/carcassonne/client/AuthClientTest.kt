package carcassonne.client

import carcassonne.service.AuthService
import carcassonne.statemachine.auth.AuthStateMachineFactory
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock

class AuthClientTest {

    @InjectMocks
    private lateinit var authClient: AuthClient

    @Mock
    private lateinit var authService: AuthService

    private val authStateMachine = AuthStateMachineFactory.getInstance()

    @Test
    fun testLogin() {
        authClient.login(TEST_USERNAME, TEST_PASSWORD)
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
    }
}
