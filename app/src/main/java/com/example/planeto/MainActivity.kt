package com.example.planeto

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //THIS LINE IS USED TO MAKE SCREEN FULL AND WHEN UPPER SIDE IS SCROLLED THEN NOTIFICATION TAB AND BUTTON AT BELOW WILL VISIBLE SOME TIME AND AFTER THAT GONE.
        window.decorView.apply { systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN }
        recycler_view.adapter = planeto_adapter(SetData.setplanetdata())
        recycler_view.layoutManager = LinearLayoutManager(this)
    }


//    private fun customdialogue(message: String){
//        val dialogs = Dialog(this)
//        dialogs.requestWindowFeature(Window.FEATURE_NO_TITLE)
//        dialogs.setContentView(R.layout.alert_dialog)
//        dialogs.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
//
//        val yesbtn : Button = findViewById(R.id.yesbtn)
//        val nobtn : Button = findViewById(R.id.nobtn)
//
//        yesbtn.setOnClickListener {
//            finishAffinity()
//        }
//
//        nobtn.setOnClickListener {
//            dialogs.dismiss()
//        }
//
//
//        dialogs.show()
//    }




    override fun onBackPressed() {
        val message:String = "Want to exit??"

        val build  = AlertDialog.Builder(this)
        build.setTitle("Exit App")
        build.setMessage("Do you want to exit an app?")
        build.setCancelable(true)
        build.setPositiveButton("Yes"){
            dialog,which -> finishAffinity()
        }

        build.setNegativeButton("No"){
            dialog,which -> dialog.cancel()
        }

        build.show()
    }
}