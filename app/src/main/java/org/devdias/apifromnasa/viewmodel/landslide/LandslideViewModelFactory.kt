package org.devdias.apifromnasa.viewmodel.landslide

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.devdias.apifromnasa.repo.Repository

/**
 * Created by Dias Bakhtybek on 23.08.2021..
 * ViewModelFactory class for LandslideViewModel
 **/

class LandslideViewModelFactory (private  val repository: Repository
): ViewModelProvider.Factory  {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(LandslideViewModel::class.java)){
            return LandslideViewModel(repository) as T
        }
        throw IllegalArgumentException ("UnknownViewModel")
    }
}