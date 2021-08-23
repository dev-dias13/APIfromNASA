package org.devdias.apifromnasa

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import org.devdias.apifromnasa.databinding.FragmentHomeBinding

/**
 * Created by Dias Bakhtybek on 23.08.2021..
 * Home fragment
 **/

class HomeFragment : Fragment() {
    private lateinit var homeDataBinding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        homeDataBinding = FragmentHomeBinding.inflate(inflater, container, false)
        homeDataBinding.lifecycleOwner = this
        homeDataBinding.CardMeteoriteLanding.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_mapFragment)
        }
        homeDataBinding.CardLandslide.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_landslideFragment)
        }
        return homeDataBinding.root
    }

}