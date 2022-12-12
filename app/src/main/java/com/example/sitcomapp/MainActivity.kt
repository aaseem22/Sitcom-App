package com.example.sitcomapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sitcomapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        binding?.tvWelcome?.alpha=0f
        binding?.tvWelcome?.animate()?.setDuration(1500)?.alpha(1f)?.withEndAction{
            overridePendingTransition(android.R.anim.accelerate_interpolator,android.R.anim.decelerate_interpolator)
        }
        binding?.flStart?.setOnClickListener {
            val i = Intent(this,ListOfSitcoms::class.java )
            startActivity(i)
        }
        binding?.flStart?.alpha=0f
        binding?.flStart?.animate()?.setDuration(1300)?.alpha(1f)?.withEndAction{
            overridePendingTransition(android.R.anim.bounce_interpolator,android.R.anim.slide_in_left)
        }

    }
}