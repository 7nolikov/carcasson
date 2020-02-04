package carcassonne.service

import org.springframework.stereotype.Service

interface AuthService {
    fun login(username: String, password: String): String
    fun register(): String
    fun checkVerificationCode(): Boolean
    fun resetPassword(): String
    fun logout()
}

@Service
class AuthServiceImpl: AuthService {

    override fun login(username: String, password: String): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun register(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
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

}
