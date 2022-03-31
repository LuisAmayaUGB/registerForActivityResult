package com.example.ejercicio1kotlin

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val SECOND_ACTIVITY_REQUEST_CODE = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



getResultButton.setOnClickListener {
    openActivityForResult()
}



    }









    fun openActivityForResult() {
        startForResult.launch(Intent(this, MainActivity2::class.java))
    }


    val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK) {
            val intent = result.data

                 resultTextView.text = result.data!!.extras?.getString("keyName")
                    ?: "No Result Provided"




        }
    }




}


