package com.proyecttemperature.controller

import com.proyecttemperature.model.Device
import com.proyecttemperature.service.DeviceService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import java.util.*

@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT, RequestMethod.DELETE])
@Controller
@RequestMapping("/device")
class DeviceController {
    @Autowired
    lateinit var deviceService: DeviceService
    @GetMapping
    fun list ():List <Device>{
        return deviceService.list()
    }

    @GetMapping("/{id}")
    fun listOne (@PathVariable id: Long) : Optional<Device> {
        return deviceService.listOne(id)
    }

    //Peticiones post - Clase controller
    @PostMapping
    fun save (@RequestBody device: Device): ResponseEntity<Device> {
        return ResponseEntity(deviceService.save(device), HttpStatus.OK)
    }

    //clase controller - Petición Put
    @PutMapping
    fun update (@RequestBody device: Device): ResponseEntity<Device> {
        return ResponseEntity(deviceService.update(device), HttpStatus.OK)
    }

    //clase  controller-Petiicon Patch
    @PatchMapping
    fun updateName (@RequestBody device: Device): ResponseEntity<Device> {
        return ResponseEntity(deviceService.update(device), HttpStatus.OK)
    }

    //clase  controller - Petición Delete
    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return deviceService.delete(id)
    }
}