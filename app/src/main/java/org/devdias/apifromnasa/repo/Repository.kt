package org.devdias.apifromnasa.repo

import org.devdias.apifromnasa.api.RetrofitInstance
import org.devdias.apifromnasa.data.landslide.Landslide
import org.devdias.apifromnasa.data.meteorite.Meteorite
import retrofit2.Call

/**
 * Created by Dias Bakhtybek on 23.08.2021..
 * Repository class for a bunch of ViewModel and APi
 **/

class Repository {
    fun getMeteoriteInfo(): Call<List<Meteorite>> {
        return RetrofitInstance.createConnection.getMeteoriteData()
    }

    fun getLandslideInfo(): Call<List<Landslide>> {
        return RetrofitInstance.createConnection.getLandslideData()
    }
}