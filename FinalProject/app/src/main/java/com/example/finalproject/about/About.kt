package com.example.finalproject.about

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.finalproject.R
import com.example.finalproject.databinding.ActivityAboutBinding

class About : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        binding.toolbar.setTitleTextColor(Color.WHITE);
        supportActionBar!!.title= "About"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        binding.bVisitGithub.setOnClickListener(this)

        binding.bVisitInstagram.setOnClickListener(this)

        val img = "https://media.licdn.com/dms/image/C4E03AQG87LwI3q4TEA/profile-displayphoto-shrink_400_400/0/1634403891997?e=1683763200&v=beta&t=DH4PdtBCFIamx-sLx-klgmMmMnvUWuMiaNJKLaoMW9c"

        Glide.with(this)
            .load(img)
            .apply(RequestOptions())
            .into(binding.imgItemPhoto)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.b_visit_instagram -> {
                var browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/pmfadel"));
                startActivity(browserIntent);
            }
            R.id.b_visit_github -> {
                var browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/fadel2002"));
                startActivity(browserIntent);
            }
        }

    }
}