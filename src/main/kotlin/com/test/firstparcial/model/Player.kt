package com.test.firstparcial.model

import javax.persistence.*

@Entity
@Table(name = "person")

class Player {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)

    var id: Long? = null
    var name: String? = null
    var last_name: String? = null
    var age: Long? = null
}