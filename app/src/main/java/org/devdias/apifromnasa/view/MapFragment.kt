package org.devdias.apifromnasa.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import org.devdias.apifromnasa.R
import org.devdias.apifromnasa.data.meteorite.Meteorite
import org.devdias.apifromnasa.databinding.FragmentMapBinding
import org.devdias.apifromnasa.repo.Repository
import org.devdias.apifromnasa.viewmodel.meteorite.MapViewModel
import org.devdias.apifromnasa.viewmodel.meteorite.MapViewModelFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by Dias Bakhtybek on 23.08.2021..
 * MapFragment (presented Meteorite data)
 **/

class MapFragment : Fragment() {
    private lateinit var googleMap: GoogleMap
    private lateinit var viewModel: MapViewModel
    private lateinit var mapDataBinding: FragmentMapBinding
    private lateinit var mapView: MapView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val repository = Repository()
        // Inflate the layout for this fragment
        mapDataBinding = FragmentMapBinding.inflate(inflater, container, false)
        val factory = MapViewModelFactory(repository)
        viewModel = ViewModelProviders.of(this, factory).get(MapViewModel::class.java)
        mapDataBinding.mapViewModel = viewModel
        mapDataBinding.lifecycleOwner = this
        mapDataBinding.progressBar.visibility = View.VISIBLE
        mapDataBinding.ToolBar.setNavigationOnClickListener{findNavController().navigate(R.id.action_mapFragment_to_homeFragment) }
        mapView = mapDataBinding.mapView
        mapView.onCreate(savedInstanceState)
        mapView.onResume()
        viewModel.getInfo()
        viewModel.list.observe(viewLifecycleOwner, { response ->
            getInfo(response)
        })

        return mapDataBinding.root
    }

    private fun getInfo(response: Call<List<Meteorite>>) {
            response.enqueue(object : Callback<List<Meteorite>> {
                override fun onResponse(call: Call<List<Meteorite>>, response: Response<List<Meteorite>>) =
                    if(response.isSuccessful) {
                        val items = response.body()!!
                        setupMarkers(items)
                    } else {
                        println("Response failed")
                    }
                override fun onFailure(call: Call<List<Meteorite>>, t: Throwable) {
                    Log.d("Error:", t.localizedMessage!!)
                }
            })
    }

    private fun setupMarkers(items: List<Meteorite>) {
        var index = 0
        mapView.getMapAsync { mMap ->
            googleMap = mMap
            while(index < items.size) {
                val lang = items[index].reclat
                val long = items[index].reclong
                val name = items[index].name
                val mass = items[index].mass
                val year = items[index].year
                try {
                    val location1 = LatLng(lang!!, long!!)
                    googleMap.addMarker(
                        MarkerOptions().position(location1).title("Name: $name")
                            .snippet("Mass: $mass; Year: $year")
                    )
                } catch (e: Exception) {
                    e.printStackTrace()
                }
                index++
            }
        }
        mapDataBinding.progressBar.visibility = View.GONE
    }
}