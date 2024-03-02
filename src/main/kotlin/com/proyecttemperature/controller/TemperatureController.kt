package com.proyecttemperature.controller

import com.proyecttemperature.model.Temperature
import com.proyecttemperature.service.TemperatureService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/temperature")
class TemperatureController {
    @Autowired
    lateinit var temperatureService: TemperatureService
    @GetMapping
    fun list ():List <Temperature>{
        return temperatureService.list()
    }

    @GetMapping("/{id}")
    fun listOne (@PathVariable id: Long) : Optional<Temperature> {
        return temperatureService.listOne(id)
    }

    //Peticiones post - Clase controller
    @PostMapping
    fun save (@RequestBody temperature: Temperature): ResponseEntity<Temperature> {
        return ResponseEntity(temperatureService.save(temperature), HttpStatus.OK)
    }

    //clase controller - Petición Put
    @PutMapping
    fun update(@RequestBody temperature: Temperature): ResponseEntity<Temperature> {
        return ResponseEntity(temperatureService.update(temperature), HttpStatus.OK)
    }

    //clase  controller-Petiicon Patch
    @PatchMapping
    fun updateName (@RequestBody temperature: Temperature): ResponseEntity<Temperature> {
        return ResponseEntity(temperatureService.update(temperature), HttpStatus.OK)
    }

    //clase  controller - Petición Delete
    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return temperatureService.delete(id)
    }
}