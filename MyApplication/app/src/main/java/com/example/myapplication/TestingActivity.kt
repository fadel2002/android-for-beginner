package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView

class TestingActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnSetValue: Button
    private lateinit var tvText: TextView

    private var names = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_testing)

        tvText = findViewById(R.id.tv_text)

        btnSetValue = findViewById(R.id.btn_set_value)
        btnSetValue.setOnClickListener(this)

        names.add("Narenda Wicaksono")
        names.add("Kevin")
        names.add("Yoza")
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_set_value -> {
                // Contoh Loging
                Log.d("TestActivity", names.toString())
                val name = StringBuilder()
                for (i in 0..2) {
                    name.append(names[i]).append("\n")
                }
                tvText.text = name.toString()
            }
        }
    }
}