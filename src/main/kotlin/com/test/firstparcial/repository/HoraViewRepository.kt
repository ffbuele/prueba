package com.test.firstparcial.repository

import com.test.firstparcial.model.HoraView
import org.springframework.data.jpa.repository.JpaRepository

interface HoraViewRepository: JpaRepository<HoraView, String> {
}