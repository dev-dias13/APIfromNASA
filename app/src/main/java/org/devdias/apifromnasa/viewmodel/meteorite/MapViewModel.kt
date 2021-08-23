package org.devdias.apifromnasa.viewmodel.meteorite

import org.devdias.apifromnasa.repo.Repository
import retrofit2.Call
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.devdias.apifromnasa.data.meteorite.Meteorite

/**
 * Created by Dias Bakhtybek on 23.08.2021..
 * ViewModel Class for Meteorite view (MapFragment)
 **/

class MapViewModel(private val repository: Repository): ViewModel(), Observable {
    var list: MutableLiveData<Call<List<Meteorite>>> = MutableLiveData()

    fun getInfo() {
        list.value = repository.getMeteoriteInfo()
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }
}