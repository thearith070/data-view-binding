package com.sample.databinding

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.sample.databinding.databinding.ActivityDataBindingBinding

class DataBindingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDataBindingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding)
        setupListener()
    }

    private fun setupListener() {
        binding.btnSubmit.setOnClickListener { submit() }
    }

    private fun submit() {
        val number = binding.edtNumber.text.toString()
        if (number.isEmpty()) {
            Toast.makeText(this, "Please input Number", Toast.LENGTH_SHORT).show()
            return
        }
        binding.number = number.toInt()
    }

}