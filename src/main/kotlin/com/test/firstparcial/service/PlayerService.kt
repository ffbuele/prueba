package com.test.firstparcial.service

import com.test.firstparcial.model.Player
import com.test.firstparcial.repository.PlayerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service

class PlayerService {
    @Autowired
    lateinit var playerRepository: PlayerRepository

    fun list (): List<Player>{
        return playerRepository.findAll()
    }

    fun getById (id:Long?): Player?{
        return playerRepository.findById(id)
    }

    fun save(player: Player): Player{
        return playerRepository.save(player)
    }

    fun update(player: Player): Player{
        playerRepository.findById(player.id) ?: throw Exception()
        return playerRepository.save(player)
    }

    fun updateOne(player: Player): Player {
        val response = playerRepository.findById(player.id)
            ?: throw Exception()
        response.apply {
            name = player.name
        }

        return playerRepository.save(response)
    }

    fun delete (id:Long): Boolean{
        playerRepository.deleteById(id)
        return true
    }
}