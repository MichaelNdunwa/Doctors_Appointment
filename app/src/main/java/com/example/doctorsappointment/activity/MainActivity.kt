package com.example.doctorsappointment.activity

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.doctorsappointment.adapter.NearDoctorsAdapter
import com.example.doctorsappointment.databinding.ActivityMainBinding
import com.example.doctorsappointment.view_model.MainViewModel

class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initNearByDoctor()
    }

    private fun initNearByDoctor() {
        binding.apply {
            progressBar.visibility = View.VISIBLE
            viewModel.loadDoctors().observe(this@MainActivity, Observer {
                doctorList.layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
                doctorList.adapter = NearDoctorsAdapter(it)
                progressBar.visibility = View.GONE
            })
        }
    }
}