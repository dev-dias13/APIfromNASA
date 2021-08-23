package org.devdias.apifromnasa.viewmodel.meteorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.devdias.apifromnasa.repo.Repository

/**
 * Created by Dias Bakhtybek on 23.08.2021..
 * ViewModelFactory class for MapViewModel
 **/

class MapViewModelFactory(private  val repository: Repository
): ViewModelProvider.Factory  {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MapViewModel::class.java)){
            return MapViewModel(repository) as T
        }
        throw IllegalArgumentException ("UnknownViewModel")
    }
}