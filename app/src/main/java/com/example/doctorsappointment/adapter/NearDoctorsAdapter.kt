package com.example.doctorsappointment.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.request.RequestOptions
import com.example.doctorsappointment.activity.DetailActivity
import com.example.doctorsappointment.databinding.ViewholderNearbyDoctorBinding
import com.example.doctorsappointment.model.DoctorsModel

class NearDoctorsAdapter(val items: MutableList<DoctorsModel>):
    RecyclerView.Adapter<NearDoctorsAdapter.ViewHolder>() {

    private var context: Context? = null

    class ViewHolder(val binding: ViewholderNearbyDoctorBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NearDoctorsAdapter.ViewHolder {
        context = parent.context
        return ViewHolder(ViewholderNearbyDoctorBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: NearDoctorsAdapter.ViewHolder, position: Int) {
        holder.binding.apply {
            doctorName.text = items[position].name
            special.text = items[position].special
            costPerHour.text = items[position].cost

            Glide.with(holder.itemView.context).load(items[position].picture)
                .apply { RequestOptions().transform(CenterCrop())}
                .into(profileImage)

            root.setOnClickListener {
                val intent = Intent(context, DetailActivity::class.java)
                intent.putExtra("object", items[position])
                context?.startActivity(intent)
            }
        }

    }

    override fun getItemCount(): Int = items.size
}