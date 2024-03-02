package com.proyecttemperature.service

import com.proyecttemperature.model.Temperature
import com.proyecttemperature.repository.DeviceRepository
import com.proyecttemperature.repository.TemperatureRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import java.util.*

@Service
class TemperatureService {
    @Autowired
    lateinit var temperatureRepository: TemperatureRepository

    @Autowired
    lateinit var deviceRepository: DeviceRepository

    fun list(): List<Temperature> {
        return temperatureRepository.findAll()
    }

    fun listOne(id: Long): Optional<Temperature> {
        return temperatureRepository.findById(id)
    }

    // PETICIONES POST
    fun save(modelo: Temperature): Temperature {
        try {
            deviceRepository.findById(modelo.deviceId) // Usar "modelo.deviceId" en lugar de "modelo.clientId"
                ?: throw Exception("Id del autor no encontrado")
            return temperatureRepository.save(modelo)
        } catch (ex: Exception) {
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message)
        }
    }

    // clase service -Petición put
    fun update(modelo: Temperature): Temperature {
        try {
            temperatureRepository.findById(modelo.id)
                ?: throw Exception("ID no existe")

            return temperatureRepository.save(modelo)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    //Delete by id
    fun delete(id: Long?): Boolean? {
        try {
            val response = temperatureRepository.findById(id)
                ?: throw Exception("ID no existe")
            temperatureRepository.deleteById(id!!)
            return true
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }
}