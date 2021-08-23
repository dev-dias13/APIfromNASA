package org.devdias.apifromnasa.viewmodel.landslide

import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.devdias.apifromnasa.data.landslide.Landslide
import org.devdias.apifromnasa.repo.Repository
import retrofit2.Call

/**
 * Created by Dias Bakhtybek on 23.08.2021..
 * ViewModel class for for Landslide view (LandslideFragment)
 **/

class LandslideViewModel(private val repository: Repository): ViewModel(), Observable {
    var listLandslide: MutableLiveData<Call<List<Landslide>>> = MutableLiveData()

    fun getLandslideInfo() {
        listLandslide.value = repository.getLandslideInfo()
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }
}