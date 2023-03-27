package com.sample.databinding

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.sample.databinding.databinding.ActivityViewBindingBinding

class ViewBindingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityViewBindingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewBindingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupListener()
    }

    private fun setupListener() {
        binding.btnSum.setOnClickListener {
            val a = binding.edtA.text.toString()
            val b = binding.edtB.text.toString()

            if (a.isEmpty()) {
                Toast.makeText(this, "Please input A", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (b.isEmpty()) {
                Toast.makeText(this, "Please input B", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            sum(a.toInt(), b.toInt())

        }
    }

    private fun sum(a: Int, b: Int) {
        binding.tvResult.text = "Result is: ${a + b}"
    }

}