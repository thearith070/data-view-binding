package com.sample.databinding

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.sample.databinding.databinding.Activity2waysDataBindingBinding

class TwoWaysDataBindingActivity : AppCompatActivity() {

    private lateinit var binding: Activity2waysDataBindingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_2ways_data_binding)
        setupListener()
    }

    private fun setupListener() {
        binding.btnCopy.setOnClickListener {
            if (binding.valueA.isNullOrEmpty()) {
                Toast.makeText(this, "Please input A", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            binding.valueB = binding.valueA

        }
    }
}