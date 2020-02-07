package carcassonne.exception

class PasswordIncorrectException(username: String) : Exception("Password for username: $username is not correct")
