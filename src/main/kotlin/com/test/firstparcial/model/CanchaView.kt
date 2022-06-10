package com.test.firstparcial.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "cancha_view")
class CanchaView {
    @Id
    @Column(updatable = false)
    var cancha: String? = null
    var frequency: Long? = null
}