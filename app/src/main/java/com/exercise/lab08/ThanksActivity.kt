package com.exercise.lab08

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.exercise.lab08.databinding.ActivityThanksBinding

class ThanksActivity : AppCompatActivity() {

    private lateinit var binding: ActivityThanksBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityThanksBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.nameText2.text = intent.getStringExtra("name")
        binding.phoneNoText2.text = intent.getStringExtra("phone")
        binding.sizeTextView2.text = intent.getStringExtra("size")
        binding.pickupDateTextView.text = intent.getStringExtra("date")
        binding.pickupTimeTextView.text = intent.getStringExtra("time")

        binding.sendBtn.setOnClickListener {
            binding.ratingTextView.text = binding.ratingBar.rating.toString()
        }

    }
}