package com.example.doctorsappointment.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.doctorsappointment.model.DoctorsModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainRepository {
    private val firebaseDatabase = FirebaseDatabase.getInstance()

    fun load(): LiveData<MutableList<DoctorsModel>> {
        val listData = MutableLiveData<MutableList<DoctorsModel>>()
        val ref = firebaseDatabase.getReference("doctors")
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val list = mutableListOf<DoctorsModel>()
                for (dataSnapshot in snapshot.children) {
                    val doctorsModel = dataSnapshot.getValue(DoctorsModel::class.java)
                    doctorsModel?.let { list.add(it) }
                }
                listData.value = list

            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
        return listData
    }
}