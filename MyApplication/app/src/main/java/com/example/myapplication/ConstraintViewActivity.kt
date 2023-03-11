package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ConstraintViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constraint_view)

        supportActionBar?.title = "Constraint View Example"
        supportActionBar?.subtitle = "Page"
    }
}