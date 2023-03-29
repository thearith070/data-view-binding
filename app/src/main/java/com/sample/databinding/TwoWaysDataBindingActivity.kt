package com.sample.databinding

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.sample.databinding.databinding.Activity2waysDataBindingBinding

class TwoWaysDataBindingActivity : AppCompatActivity() {

    private lateinit var binding: Activity2waysDataBindingBinding
    private val user = User("Thearith", "thearith@gmail.com")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_2ways_data_binding)
        binding.user = user
        setupListener()
    }

    private fun setupListener() {
        binding.btnPrint.setOnClickListener {
            println(user)
        }
    }
}

data class User(
    var name: String,
    var email: String
)