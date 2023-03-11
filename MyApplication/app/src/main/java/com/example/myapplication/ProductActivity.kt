package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ProductActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        supportActionBar?.title = "Google Pixel"
        supportActionBar?.subtitle = "Phone"
    }
}