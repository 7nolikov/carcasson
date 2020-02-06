package carcassonne.service

import carcassonne.domain.meeple.Meeple
import carcassonne.domain.meeple.MeepleType
import carcassonne.domain.player.Player
import carcassonne.repository.PlayerRepository
import carcassonne.statemachine.auth.Event
import carcassonne.statemachine.auth.SideEffect
import carcassonne.statemachine.auth.State
import com.tinder.StateMachine
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.junit5.MockKExtension
import io.mockk.mockk
import io.mockk.verify
import org.amshove.kluent.`should be`
import org.amshove.kluent.`should equal`
import org.amshove.kluent.`should not be`
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import java.util.*

@ExtendWith(MockKExtension::class)
class AuthServiceTest {

    @InjectMockKs
    private lateinit var authService: AuthServiceImpl

    private val authStateMachine = mockk<StateMachine<State, Event, SideEffect>>()
    private val playerRepository = mockk<PlayerRepository>()

    @Test
    fun `Test login in positive case`() {
        every {
            playerRepository.findById(TEST_USERNAME)
        } returns Optional.of(player)
        val token = authService.login(
            TEST_USERNAME,
            TEST_PASSWORD
        )
        token `should not be` null
        token `should equal` TEST_TOKEN
        authStateMachine.state `should equal` State.Logged
    }

    @Test
    fun `Test register in positive case`() {
        val verificationCode = authService.register()
        verificationCode `should not be` null
        verificationCode `should equal` TEST_VERIFICATION_CODE
        authStateMachine.state `should equal` State.PendingVerification
    }

    @Test
    fun `Test checking of verification code in positive case`() {
        val isVerificationCodeAccepted = authService.checkVerificationCode()
        isVerificationCodeAccepted `should be` true
        authStateMachine.state `should equal` State.Logged
    }

    @Test
    fun `Test password reset in positive case`() {
        val verificationCode = authService.resetPassword()
        verificationCode `should not be` null
        verificationCode `should equal` TEST_VERIFICATION_CODE
        authStateMachine.state `should equal` State.PasswordReset
    }

    @Test
    fun `Test logout in positive case`() {
        authService.logout()
        verify {
            authService.logout()
        }
        authStateMachine.state `should equal` State.NotLogged
    }

    companion object {
        private const val TEST_USERNAME = "John Doe"
        private const val TEST_PASSWORD = "secretpassword"
        private const val TEST_TOKEN = "secrettoken"
        private const val TEST_VERIFICATION_CODE = "verificationcode"
        private const val TEST_EMAIL = "test@gmail.com"
        private val meeple = Meeple(id = 1, type = MeepleType.DEFAULT)
        private val TEST_MEEPLES = listOf(meeple)
        private const val TEST_SCORE = 1000
        private val player =
            Player(name = TEST_USERNAME, password = TEST_PASSWORD, email = TEST_EMAIL, meeples = TEST_MEEPLES, score = TEST_SCORE)
    }
}
