package org.devdias.apifromnasa.api

import org.devdias.apifromnasa.data.landslide.Landslide
import org.devdias.apifromnasa.data.meteorite.Meteorite
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
/**
 * Created by Dias Bakhtybek on 23.08.2021..
 * Interface for API
 **/

interface RetrofitInterface {
    @GET("/resource/{filenameJSON}.json")
    fun getMeteoriteData(
        @Path("filenameJSON", encoded=true) resource: String = "gh4g-9sfh",
    ): Call<List<Meteorite>>

    @GET("/resource/{filenameJSON}.json")
    fun getLandslideData(
        @Path("filenameJSON", encoded=true) resource: String = "dd9e-wu2v",
    ): Call<List<Landslide>>
}