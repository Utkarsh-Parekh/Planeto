package com.example.planeto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_planet_details.*
import kotlinx.android.synthetic.main.planeto_view.*

class planet_details : AppCompatActivity() {

    private lateinit var planetobj:planetData
    private var planetimagesobj:Int?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_planet_details)

        window.decorView.apply { systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN }


        planetobj = intent.getParcelableExtra("planet-key")!!
        planetimagesobj = intent.getIntExtra("planet-image",-1)

        settingdatainfo(planetobj, planetimagesobj!!)


        home_btn.setOnClickListener {
            val ihome = Intent(this,MainActivity::class.java)
            startActivity(ihome)
            finish()
        }
    }

    private fun settingdatainfo(planetobj:planetData,planeimagesobj:Int) {

        planet_name_detail.text = planetobj.title
        planet_distance_detail.text = planetobj.distance + "m km"
        planet_gravity_detail.text = planetobj.gravity + "m/ss"
        overview_info.text = planetobj.overview
        planet_sub_detail.text = planetobj.galaxy
        planet_detail_img.setImageResource(planeimagesobj)

    }
}