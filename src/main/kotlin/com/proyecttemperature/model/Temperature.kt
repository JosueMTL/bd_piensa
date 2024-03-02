package com.proyecttemperature.model

import jakarta.persistence.*
import java.math.BigDecimal
import java.sql.Timestamp

@Entity
@Table(name = "temperature")
class Temperature {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    var id: Long? = null

    @Column(name = "date_hour")
    var dateHour: Timestamp? = null

    @Column(name = "humidity_value")
    var humidityValue: BigDecimal? = null

    @Column(name = "device_id")
    var deviceId: Long? = null
}