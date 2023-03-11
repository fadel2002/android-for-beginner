package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class HeroDetailActivity : AppCompatActivity() {
    private lateinit var ivHeroPhoto:ImageView
    private lateinit var tvHeroName:TextView
    private lateinit var tvHeroDescription:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hero_detail)

        ivHeroPhoto = findViewById(R.id.iv_hero_photo)
        tvHeroName = findViewById(R.id.tv_hero_name)
        tvHeroDescription = findViewById(R.id.tv_hero_description)

        val data = intent.getParcelableExtra<Hero>("DATA")
        tvHeroDescription.text = data?.description.toString()
        tvHeroName.text = data?.name.toString()
        Glide.with(this)
            .load(data?.photo.toString()) // URL Gambar
            .into(ivHeroPhoto)
    }
}