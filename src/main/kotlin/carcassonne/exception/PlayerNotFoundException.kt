package carcassonne.exception

class PlayerNotFoundException(username: String) : Exception("Player with username: $username not found")
