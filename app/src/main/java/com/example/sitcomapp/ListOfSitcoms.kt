package com.example.sitcomapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sitcomapp.databinding.ActivityListOfSitcomsBinding

class ListOfSitcoms : AppCompatActivity() {
    private var binding :ActivityListOfSitcomsBinding?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListOfSitcomsBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        val mainAdapter : MainAdapter= MainAdapter(SitcomList.sitcomList)
        binding?.rvSitcom?.layoutManager=LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        binding?.rvSitcom?.adapter= mainAdapter

        mainAdapter.setOnClickListner(object:MainAdapter.OnClickListner{
            override fun onClick(position: Int) {
               val i = Intent(this@ListOfSitcoms, theOffice::class.java)
                startActivity(i)
            }
        })

    }

    override fun onDestroy() {
        super.onDestroy()
        binding= null
    }
}