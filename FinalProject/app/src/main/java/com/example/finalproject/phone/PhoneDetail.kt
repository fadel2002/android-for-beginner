package com.example.finalproject.phone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.finalproject.databinding.ActivityPhoneDetailBinding

class PhoneDetail : AppCompatActivity() {
    private lateinit var binding: ActivityPhoneDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPhoneDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val data = intent.getParcelableExtra<Phone>("DATA")

        supportActionBar?.title = data?.name.toString()
        binding.textPrice.text = data?.price.toString()
        binding.textSpecDisplay.text = data?.display.toString()
        binding.textSpecSize.text = data?.size.toString()
        binding.textBattery.text = data?.battery.toString()
        binding.textCpu.text = data?.cpu.toString()
        binding.textGpu.text = data?.gpu.toString()
        binding.textSeller.text = data?.seller.toString()
        Glide.with(this)
            .load(data?.photo.toString())
            .into(binding.ivImagePhone)

        binding.bShare.setOnClickListener{
            val intent = Intent(Intent.ACTION_SEND)
            intent.putExtra(Intent.EXTRA_TEXT,"HP " + data?.name.toString() + " dengan harga yang terjangkau yaitu " + data?.price.toString())
            intent.type="text/plain"
            startActivity(Intent.createChooser(intent,"Share with"))
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}