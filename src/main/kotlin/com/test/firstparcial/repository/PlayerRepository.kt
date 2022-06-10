package com.test.firstparcial.repository

import com.test.firstparcial.model.Player
import org.springframework.data.jpa.repository.JpaRepository

interface PlayerRepository: JpaRepository<Player, Long> {

}