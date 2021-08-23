package org.devdias.apifromnasa.data.meteorite;

/**
 * Created by Dias Bakhtybek on 23.08.2021..
 * Main data class for Meteorite (POJO)
 **/

data class Meteorite (
    val name: String,
    val id: String,
    val nametype: String,
    val recclass: String,
    val mass: String,
    val fall: String,
    val year: String,
    val reclat: Double,
    val reclong: Double,
    val geolocation: Geolocation
)