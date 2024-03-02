package com.proyecttemperature.repository

import com.proyecttemperature.model.Temperature
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TemperatureRepository : JpaRepository<Temperature, Long?> {
    fun findById (id: Long?): Temperature?

}