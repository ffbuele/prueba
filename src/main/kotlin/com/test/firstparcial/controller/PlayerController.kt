package com.test.firstparcial.controller

import com.test.firstparcial.model.Player
import com.test.firstparcial.service.PlayerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/players")

class PlayerController {
    @Autowired
    lateinit var playerService: PlayerService

    @GetMapping
    fun list(): List<Player>{
        return playerService.list()
    }

    @GetMapping("/id")
    fun listById(@PathVariable("id") id:Long): Player?{
        return playerService.getById(id)
    }

    @GetMapping("/hora/{hora}")
    fun getByHora (@PathVariable("hora") hora: String): List<Player>?{
        return playerService.getByHora(hora)
    }

    @GetMapping("/cancha/{cancha}")
    fun getByCancha (@PathVariable("cancha") cancha: String): List<Player>?{
        return playerService.getByCancha(cancha)
    }

    @PostMapping
    fun save (@RequestBody player: Player): Player{
        return playerService.save(player)
    }

//    @PutMapping
//    fun update (@RequestBody player: Player): Player{
//        return playerService.update(player)
//    }
//
//    @PatchMapping
//    fun updateOne (@RequestBody player: Player): Player{
//        return playerService.updateOne(player)
//    }
//
//    @DeleteMapping("/delete/{id}")
//    fun delete (@PathVariable("id") id: Long):Boolean{
//        return playerService.delete(id)
//    }
}