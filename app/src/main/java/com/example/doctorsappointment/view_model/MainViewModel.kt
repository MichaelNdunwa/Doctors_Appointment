package com.example.doctorsappointment.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.doctorsappointment.model.DoctorsModel
import com.example.doctorsappointment.repository.MainRepository

class MainViewModel(): ViewModel() {
    private val repository = MainRepository()
    fun loadDoctors(): LiveData<MutableList<DoctorsModel>> {
        return repository.load()
    }
}