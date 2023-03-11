package com.example.myapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

//    private lateinit var edtWidth: EditText
//    private lateinit var edtHeight: EditText
//    private lateinit var edtLength: EditText
//    private lateinit var btnCalculate: Button
//    private lateinit var tvResult: TextView
//    private lateinit var btnMoveActivity: Button
//    private lateinit var btnMoveWithDataActivity: Button
//    private lateinit var btnMoveWithObject:Button
//    private lateinit var btnDialPhone:Button
//    private lateinit var tvResultRadioGroup: TextView
//    private lateinit var btnMoveForResult:Button
//    private lateinit var btnMoveTestingActivity:Button
//    private lateinit var btnMoveProductActivity:Button
//    private lateinit var btnMoveConstraintViewActivity:Button
//    private lateinit var btnMoveToHeroesGallery:Button

    private lateinit var binding: ActivityMainBinding

    private val resultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == MoveForResultActivity.RESULT_CODE && result.data != null) {
            val selectedValue =
                result.data?.getIntExtra(MoveForResultActivity.EXTRA_SELECTED_VALUE, 0)
            binding.tvResultRadioGroup.text = "Hasil : $selectedValue"
        }
    }

    companion object {
        private const val STATE_RESULT = "state_result"
        private const val STATE_RADIO_GROUP_RESULT = "state_radio_group_result"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalculate.setOnClickListener(this)

        binding.btnMoveActivity.setOnClickListener(this)

        binding.btnMoveActivityData.setOnClickListener(this)

        binding.btnMoveActivityObject.setOnClickListener(this)

        binding.btnDialNumber.setOnClickListener(this)

        binding.btnMoveForResult.setOnClickListener(this)

        binding.btnMoveTestingActivity.setOnClickListener(this)

        binding.btnProductActivity.setOnClickListener(this)

        binding.btnConstraintViewActivity.setOnClickListener(this)

        binding.btnMoveToHeroesGallery.setOnClickListener(this)

        if (savedInstanceState != null) {
            binding.tvResult.text = savedInstanceState.getString(STATE_RESULT)
            binding.tvResultRadioGroup.text = savedInstanceState.getString(STATE_RADIO_GROUP_RESULT)
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_calculate -> {
                val inputLength = binding.edtLength.text.toString().trim()
                val inputWidth = binding.edtWidth.text.toString().trim()
                val inputHeight = binding.edtHeight.text.toString().trim()
                var isEmptyFields = false

                if (inputLength.isEmpty()) {
                    isEmptyFields = true
                    binding.edtLength.error = "Field ini tidak boleh kosong"
                }
                if (inputWidth.isEmpty()) {
                    isEmptyFields = true
                    binding.edtWidth.error = "Field ini tidak boleh kosong"
                }
                if (inputHeight.isEmpty()) {
                    isEmptyFields = true
                    binding.edtHeight.error = "Field ini tidak boleh kosong"
                }

                if (!isEmptyFields) {
                    val volume = inputLength.toDouble() * inputWidth.toDouble() * inputHeight.toDouble()
                    binding.tvResult.text = volume.toString()
                }
            }
            R.id.btn_move_activity -> {
                val moveIntent = Intent(this@MainActivity, MoveActivity::class.java)
                startActivity(moveIntent)
            }
            R.id.btn_move_activity_data -> {
                val moveWithDataIntent = Intent(this@MainActivity, MoveWithDataActivity::class.java)
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME, "DicodingAcademy Boy")
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE, 5)
                startActivity(moveWithDataIntent)
            }
            R.id.btn_move_activity_object -> {
                val person = Person(
                    "DicodingAcademy",
                    5,
                    "academy@dicoding.com",
                    "Bandung"
                )
                val moveWithObjectIntent = Intent(this@MainActivity, MoveWithObjectActivity::class.java)
                moveWithObjectIntent.putExtra(MoveWithObjectActivity.EXTRA_PERSON, person)
                startActivity(moveWithObjectIntent)
            }
            R.id.btn_dial_number -> {
                val phoneNumber = "081210841382"
                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(dialPhoneIntent)
            }
            R.id.btn_move_for_result -> {
                val moveForResultIntent = Intent(this@MainActivity, MoveForResultActivity::class.java)
                resultLauncher.launch(moveForResultIntent)
            }
            R.id.btn_move_testing_activity -> {
                val moveIntent = Intent(this@MainActivity, TestingActivity::class.java)
                startActivity(moveIntent)
            }
            R.id.btn_product_activity -> {
                val moveIntent = Intent(this@MainActivity, ProductActivity::class.java)
                startActivity(moveIntent)
            }
            R.id.btn_constraint_view_activity -> {
                val moveIntent = Intent(this@MainActivity, ConstraintViewActivity::class.java)
                startActivity(moveIntent)
            }
            R.id.btn_move_to_heroes_gallery -> {
                val moveIntent = Intent(this@MainActivity, HeroesGalleryActivity::class.java)
                startActivity(moveIntent)
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT, binding.tvResult.text.toString())
        outState.putString(STATE_RADIO_GROUP_RESULT, binding.tvResultRadioGroup.text.toString())
    }
}