package com.machfud.tubevolume

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.PI



class MainActivity : AppCompatActivity(), View.OnClickListener {
    companion object{
        private val STATE_RESULT = "state_result"
    }
    private lateinit var etRadius: EditText
    private lateinit var etHeight: EditText
    private lateinit var btnCalculateVolume: Button
    private lateinit var tvVolume: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etRadius= findViewById(R.id.edt_r)
        etHeight = findViewById(R.id.edt_height)
        btnCalculateVolume=findViewById(R.id.btn_result)
        tvVolume=findViewById(R.id.tv_result)
        btnCalculateVolume.setOnClickListener(this)
        if(savedInstanceState!=null){
            val result = savedInstanceState.getString(STATE_RESULT)
            tvVolume.text=result
        }
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.btn_result){
            val inputR = etRadius.text.toString().trim()
            val inputH = etHeight.text.toString().trim()
            val volume = PI*inputR.toDouble()*inputR.toDouble()*inputH.toDouble()
            val formattedVolume = String.format("%.2f", volume)
            tvVolume.text = formattedVolume
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT, tvVolume.text.toString())
    }
}