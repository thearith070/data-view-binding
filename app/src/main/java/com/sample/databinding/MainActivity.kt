package com.sample.databinding

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupListener()
    }

    private fun setupListener() {
        findViewById<Button>(R.id.btn_view_binding)
            .setOnClickListener {
                Toast.makeText(this, "View binding", Toast.LENGTH_LONG).show()
            }

        findViewById<Button>(R.id.btn_data_binding)
            .setOnClickListener {
                Toast.makeText(this, "Data binding", Toast.LENGTH_LONG).show()
            }

        findViewById<Button>(R.id.btn_2way_data_binding)
            .setOnClickListener {
                Toast.makeText(this, "2Ways Data binding", Toast.LENGTH_LONG).show()
            }
    }
}