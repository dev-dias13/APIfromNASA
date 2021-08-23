package org.devdias.apifromnasa.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import org.devdias.apifromnasa.R
import org.devdias.apifromnasa.adapter.LandslideAdapter
import org.devdias.apifromnasa.data.landslide.Landslide
import org.devdias.apifromnasa.databinding.FragmentLandslideBinding
import org.devdias.apifromnasa.repo.Repository
import org.devdias.apifromnasa.viewmodel.landslide.LandslideViewModel
import org.devdias.apifromnasa.viewmodel.landslide.LandslideViewModelFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by Dias Bakhtybek on 23.08.2021..
 * Landslide Fragment (presented Landslide data)
 **/

class LandslideFragment : Fragment() {
    private lateinit var viewModel: LandslideViewModel
    private lateinit var landslideDataBinding: FragmentLandslideBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val repository = Repository()
        landslideDataBinding = FragmentLandslideBinding.inflate(inflater, container, false)
        val factory = LandslideViewModelFactory(repository)
        viewModel = ViewModelProviders.of(this, factory).get(LandslideViewModel::class.java)
        landslideDataBinding.landslideViewModel = viewModel
        landslideDataBinding.lifecycleOwner = this
        landslideDataBinding.progressBar.visibility = View.VISIBLE
        landslideDataBinding.toolbar.setNavigationOnClickListener{findNavController().navigate(R.id.action_landslideFragment_to_homeFragment) }

        viewModel.getLandslideInfo()
        viewModel.listLandslide.observe(viewLifecycleOwner, Observer { response ->
            provideLandslideData(response)
        })

        return landslideDataBinding.root
    }

    private fun provideLandslideData(response: Call<List<Landslide>>?) {
        response?.clone()?.enqueue(object : Callback<List<Landslide>> {
            override fun onResponse(call: Call<List<Landslide>>, response: Response<List<Landslide>>) {
                when {response.isSuccessful -> {
                    val mainResponse = response.body()
                    //Call set up recyclerView
                    if (mainResponse != null) {
                        setupRecyclerView(mainResponse)
                    }
                    landslideDataBinding.progressBar.visibility = View.GONE
                }
                    else -> {
                        snackBar("Error: $response")
                        Log.d("Error:", response.toString())
                    }
                }
            }

            override fun onFailure(call: Call<List<Landslide>>, t: Throwable) {
                Log.d("Error:", t.localizedMessage!!)
                print(t.localizedMessage)
                snackBar("Error:" + t.localizedMessage)
            }
        })
    }

    //Setting up RecyclerView with response
    private fun setupRecyclerView(Response: List<Landslide>) {
        val adapter = LandslideAdapter(Response)
        landslideDataBinding.recyclerView.layoutManager = LinearLayoutManager(context)
        landslideDataBinding.recyclerView.adapter = adapter
    }

    // Snack bar
    private fun snackBar(message: String ) {
        view?.let { it ->
            Snackbar.make(it, message, Snackbar.LENGTH_LONG)
                .show()
        }
    }
}

