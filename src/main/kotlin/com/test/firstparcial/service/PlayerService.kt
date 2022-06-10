package com.test.firstparcial.service

import com.test.firstparcial.model.CanchaView
import com.test.firstparcial.model.HoraView
import com.test.firstparcial.model.Player
import com.test.firstparcial.repository.CanchaViewRepository
import com.test.firstparcial.repository.HoraViewRepository
import com.test.firstparcial.repository.PlayerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service

class PlayerService {
    @Autowired
    lateinit var playerRepository: PlayerRepository

    @Autowired
    lateinit var canchaViewRepository: CanchaViewRepository

    @Autowired
    lateinit var horaViewRepository: HoraViewRepository

    fun list(): List<Player>{
        return playerRepository.findAll()
    }

    fun listHoraView(): List<HoraView>?{
        return horaViewRepository.findAll()
    }

    fun listCanchaView(): List<CanchaView>?{
        return canchaViewRepository.findAll()
    }

    fun save(player: Player): Player{
        try {
            player.name?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("El name no debe ser vacio")
            player.hora?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("El hora no debe ser vacio")
            player.cancha?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("El cancha no debe ser vacio")
            return playerRepository.save(player)
        }
        catch (ex: Exception){
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }

//    fun update(player: Player): Player{
//        try {
//            player.name?.takeIf { it.trim().isNotEmpty() }
//                ?: throw Exception("El name no debe ser vacio")
//            player.hora?.takeIf { it.trim().isNotEmpty() }
//                ?: throw Exception("El hora no debe ser vacio")
//            player.cancha?.takeIf { it.trim().isNotEmpty() }
//                ?: throw Exception("El cancha no debe ser vacio")
//            return playerRepository.save(player)
//        }
//        catch (ex:Exception){
//            throw ResponseStatusException(
//                HttpStatus.NOT_FOUND, ex.message, ex)
//        }
//    }
//
//    fun updateOne(player: Player): Player {
//        try {
//            player.name?.takeIf { it.trim().isNotEmpty() }
//                ?: throw Exception("El name no debe ser vacio")
//            player.hora?.takeIf { it.trim().isNotEmpty() }
//                ?: throw Exception("El hora no debe ser vacio")
//            player.cancha?.takeIf { it.trim().isNotEmpty() }
//                ?: throw Exception("El cancha no debe ser vacio")
//            return playerRepository.save(player)
//        }
//        catch (ex:Exception){
//            throw ResponseStatusException(
//                HttpStatus.NOT_FOUND, ex.message, ex)
//        }
//    }
//
//    fun delete(id: Long): Boolean{
//        try {
//            playerRepository.findById(id)
//                ?: throw Exception("El id ${id} no existe en user")
//            playerRepository.deleteById(id)
//            return true
//        }
//        catch (ex: Exception){
//            throw ResponseStatusException(
//                HttpStatus.NOT_FOUND, ex.message, ex
//            )
//        }
//    }
}