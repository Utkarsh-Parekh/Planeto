package com.example.planeto

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.planeto_view.view.*

class planeto_adapter(var planet:List<planetData>): RecyclerView.Adapter<planeto_adapter.planetoadapter>() {

    class planetoadapter(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var title = itemView.planet_name
        var planetimage = itemView.planet_img
        var galaxyname = itemView.planet_sub
        var planetdistance = itemView.planet_distance
        var planetgravity = itemView.planet_gravity
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): planetoadapter {
        var inflater = LayoutInflater.from(parent.context).inflate(R.layout.planeto_view,parent,false);
        return planetoadapter(inflater);
    }

    override fun onBindViewHolder(holder: planetoadapter, position: Int) {
        var  dummyimage:Int?=null
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context,planet_details::class.java)
            intent.putExtra("planet-key",planet[position])
            intent.putExtra("planet-image",dummyimage)
            holder.itemView.context.startActivity(intent)
        }

        holder.title.text = planet[position].title
        holder.galaxyname.text = planet[position].galaxy
        holder.planetdistance.text = planet[position].distance + "m km"
        holder.planetgravity.text = planet[position].gravity + "m/ss"


        when(planet[position].title?.toLowerCase()){
            "mars" -> {
                dummyimage = R.drawable.mars

            }


            "jupiter" -> {
                dummyimage = R.drawable.jupiter

            }

            "moon" -> {
                dummyimage = R.drawable.moon

            }

            "mercury" -> {
                dummyimage = R.drawable.mercury

            }

            "neptune" -> {
                dummyimage = R.drawable.neptune

            }


            "saturn" -> {
                dummyimage = R.drawable.saturn

            }

            "sun" -> {
                dummyimage = R.drawable.sun

            }


            "uranus" -> {
                dummyimage = R.drawable.uranus

            }

            "venus" -> {
                dummyimage = R.drawable.venus

            }

            "earth" -> {
                dummyimage = R.drawable.earth

            }
        }

        if (dummyimage != null) {
            holder.planetimage.setImageResource(dummyimage)
        }
    }

    override fun getItemCount(): Int {
        return planet.size;
    }
}