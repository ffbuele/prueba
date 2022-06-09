package com.test.firstparcial.repository

import com.test.firstparcial.model.Player
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface PlayerRepository: JpaRepository<Player, Long> {

    fun findById(id: Long?): Player?

    @Query(nativeQuery=true)
    fun getListHora (@Param("hora")  hora:String?) : List <Player>?

    @Query(nativeQuery=true)
    fun getListCancha (@Param("cancha")  cancha:String?) : List <Player>?
}