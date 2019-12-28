package carcassonne.service

interface AuthService {
    fun login(username: String, password: String): String
    fun logout(username: String): Boolean
}
