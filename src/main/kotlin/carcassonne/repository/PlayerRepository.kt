package carcassonne.repository

import carcassonne.domain.player.Player
import org.springframework.data.jpa.repository.JpaRepository

interface PlayerRepository: JpaRepository<Player, String>
