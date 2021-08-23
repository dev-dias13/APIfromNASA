package org.devdias.apifromnasa.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.devdias.apifromnasa.R
import org.devdias.apifromnasa.data.landslide.Landslide

/**
 * Created by Dias Bakhtybek on 23.08.2021.
 * Landslide adapter for LandslideFragment
 **/

class LandslideAdapter(private val dataSet: List<Landslide>):
    RecyclerView.Adapter<LandslideAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        //val img: ImageView = view.findViewById(R.id.img)
        val eventTitle: TextView = view.findViewById(R.id.eventTitle)
        val eventDate: TextView = view.findViewById(R.id.eventDate)
        val sourceName: TextView = view.findViewById(R.id.sourceName)
        val locationDesc: TextView = view.findViewById(R.id.locationDesc)
        val locationAccuracy: TextView = view.findViewById(R.id.locationAccuracy)
        val landslideCategory: TextView = view.findViewById(R.id.landslideCategory)
        val landslideTrigger: TextView = view.findViewById(R.id.landslideTrigger)
        val countryName: TextView = view.findViewById(R.id.countryName)
        val regionName: TextView = view.findViewById(R.id.regionName)
        val eventDesc: TextView = view.findViewById(R.id.eventDesc)

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.landslide_layout, viewGroup, false)

        return ViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        //Picasso.get().load(dataSet[position].photo_link.url).into(viewHolder.img)
        viewHolder.eventTitle.text = "Event title: " + dataSet[position].event_title
        viewHolder.eventDate.text = "Event Date: " + dataSet[position].event_date
        viewHolder.sourceName.text = "Source: " + dataSet[position].source_name
        viewHolder.locationDesc.text = "Location description: " + dataSet[position].location_description
        viewHolder.locationAccuracy.text = "Accuracy: " + dataSet[position].location_accuracy
        viewHolder.landslideCategory.text = "Category: " + dataSet[position].landslide_category
        viewHolder.landslideTrigger.text = "Landslide Trigger: " + dataSet[position].landslide_trigger
        viewHolder.countryName.text = "Country: " + dataSet[position].country_name
        viewHolder.regionName.text = "Region: " + dataSet[position].admin_division_name
        viewHolder.eventDesc.text = "Description: " + dataSet[position].event_description
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}