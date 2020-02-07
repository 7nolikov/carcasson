package carcassonne.service

import carcassonne.domain.player.Player
import carcassonne.exception.PasswordIncorrectException
import carcassonne.exception.PlayerNotFoundException
import carcassonne.repository.PlayerRepository
import org.springframework.stereotype.Service
import kotlin.random.Random

interface AuthService {
    fun login(username: String, password: String): String
    fun register(username: String, password: String, email: String): String
    fun checkVerificationCode(): Boolean
    fun resetPassword(): String
    fun logout()
}

@Service
class AuthServiceImpl(
    val playerRepository: PlayerRepository
) : AuthService {

    override fun login(username: String, password: String): String {
        validatePassword(username, password)
        return getRandomString(TOKEN_UUID_STRING_LENGTH)
    }

    private fun validatePassword(username: String, password: String) {
        val player: Player = playerRepository.findById(username).orElseThrow { throw PlayerNotFoundException(username) }
        player.password.takeIf { it == password } ?: throw PasswordIncorrectException(username)
    }

    override fun register(username: String, password: String, email: String): String {
        val player = Player(name = username, password = password, email = email)
        playerRepository.save(player)
        return getRandomString(VERIFICATION_CODE_UUID_STRING_LENGTH)
    }

    override fun checkVerificationCode(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun resetPassword(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun logout() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun getRandomString(length: Int): String {
        return (1..length)
            .map { _ -> Random.nextInt(0, charPool.size) }
            .map(charPool::get)
            .joinToString("")
    }

    companion object {
        const val TOKEN_UUID_STRING_LENGTH = 10
        const val VERIFICATION_CODE_UUID_STRING_LENGTH = 4
        val charPool: List<Char> = ('a'..'z') + ('A'..'Z') + ('0'..'9')
    }
}
