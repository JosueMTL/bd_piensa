package com.proyecttemperature.service

import com.proyecttemperature.model.Device
import com.proyecttemperature.repository.DeviceRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import java.util.*

@Service
class DeviceService {
    @Autowired
    lateinit var deviceRepository: DeviceRepository

    fun list ():List<Device>{
        return deviceRepository.findAll()
    }

    fun listOne (id: Long): Optional<Device> {
        return deviceRepository.findById(id)
    }

    //PETICIONES POST
    fun save(device: Device): Device{
        try{
            return deviceRepository.save(device)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    //clase service -Petición put
    fun update(device: Device): Device{
        try {
            deviceRepository.findById(device.id)
                ?: throw Exception("ID no existe")

            return deviceRepository.save(device)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    //clase service - Delete by id
    fun delete (id: Long?):Boolean?{
        try{
            val response = deviceRepository.findById(id)
                ?: throw Exception("ID no existe")
            deviceRepository.deleteById(id!!)
            return true
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
}