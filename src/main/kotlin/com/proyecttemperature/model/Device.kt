package com.proyecttemperature.model

import jakarta.persistence.*

@Entity
@Table(name = "device")
class Device {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    var id: Long? = null

    var name: String? = null
    var location: String? = null
}