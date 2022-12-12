package com.example.sitcomapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sitcomapp.databinding.ActivitySplashScreenBinding

class SplashScreen : AppCompatActivity() {
    private var binding : ActivitySplashScreenBinding?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.ivIcon?.alpha=0f
        binding?.ivIcon?.animate()?.setDuration(1500)?.alpha(1f)?.withEndAction{
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
            finish()
    }
}
}