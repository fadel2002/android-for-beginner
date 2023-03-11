package com.example.finalproject

import android.content.Intent
import android.content.res.Configuration
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.finalproject.about.About
import com.example.finalproject.databinding.ActivityMainBinding
import com.example.finalproject.phone.Phone
import com.example.finalproject.phone.PhoneAdapter
import com.example.finalproject.phone.PhoneData
import com.example.finalproject.phone.PhoneDetail

class MainActivity : AppCompatActivity() {
    private val list = ArrayList<Phone>()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        supportActionBar?.title = "Xiaomi Phones"

        binding.rvPhones.setHasFixedSize(true)

        list.addAll(PhoneData.listData)
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.miCompose -> {
                val iAbout = Intent(this@MainActivity,
                    About::class.java)
                startActivity(iAbout)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showRecyclerList() {
        binding.rvPhones.layoutManager = if (applicationContext.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            GridLayoutManager(this, 2)
        } else {
            LinearLayoutManager(this)
        }
        val listHeroAdapter = PhoneAdapter(list)
        binding.rvPhones.adapter = listHeroAdapter

        listHeroAdapter.setOnItemClickCallback(object : PhoneAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Phone) {
                val intentToDetail = Intent(this@MainActivity, PhoneDetail::class.java)
                intentToDetail.putExtra("DATA", data)
                startActivity(intentToDetail)
            }
        })
    }
}