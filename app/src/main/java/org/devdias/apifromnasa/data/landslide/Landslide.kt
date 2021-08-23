package org.devdias.apifromnasa.data.landslide

/**
 * Created by Dias Bakhtybek on 23.08.2021..
 * Main data class for Landslide (POJO)
 **/

data class Landslide (
    val source_name: String,
    val source_link: SourceLink,
    val event_id: String,
    val event_date: String,
    val event_title: String,
    val event_description: String,
    val location_description: String,
    val location_accuracy: String,
    val landslide_category: String,
    val landslide_trigger: String,
    val landslide_size: String,
    val landslide_setting: String,
    val fatality_count: String,
    val injury_count: String,
    val photo_link: PhotoLink,
    val event_import_source: String,
    val event_import_id: String,
    val country_name: String,
    val country_code: String,
    val admin_division_name: String,
    val admin_division_population: String,
    val gazeteer_closest_point: String,
    val gazeteer_distance: String,
    val submitted_date: String,
    val created_date: String,
    val last_edited_date: String,
    val longitude: String,
    val latitude: String,
        )