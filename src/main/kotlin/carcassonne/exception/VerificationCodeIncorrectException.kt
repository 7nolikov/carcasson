package carcassonne.exception

class VerificationCodeIncorrectException(username: String) : Exception("Verification code for username: $username is not correct")
