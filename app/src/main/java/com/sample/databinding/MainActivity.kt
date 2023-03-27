package com.sample.databinding

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupListener()
    }

    private fun setupListener() {
        findViewById<Button>(R.id.btn_view_binding).setOnClickListener {
            val intent = Intent(this, ViewBindingActivity::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.btn_data_binding).setOnClickListener {
            val intent = Intent(this, DataBindingActivity::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.btn_2way_data_binding).setOnClickListener {
            val intent = Intent(this, TwoWaysDataBindingActivity::class.java)
            startActivity(intent)
        }
    }
}