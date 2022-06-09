package com.test.firstparcial.model

import javax.persistence.*

@Entity
@Table(name = "player")

class Player {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)

    var id: Long? = null
    var name: String? = null
    var hora: String? = null
    var cancha: String? = null
}