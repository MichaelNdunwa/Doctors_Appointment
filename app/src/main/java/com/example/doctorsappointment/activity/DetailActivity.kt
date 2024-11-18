package com.example.doctorsappointment.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.doctorsappointment.databinding.ActivityDetailBinding
import com.example.doctorsappointment.model.DoctorsModel

class DetailActivity : BaseActivity() {

    private lateinit var binding: ActivityDetailBinding
    private lateinit var item: DoctorsModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        item = intent.getParcelableExtra("object")!!
        getDetails()
        backNavigation()
        contactDoctor()

    }

    private fun contactDoctor() {
        binding.apply {
            websiteButton.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(item.site))
//                intent.setData(Uri.parse(item.site))
                startActivity(intent)
            }

            messageButton.setOnClickListener {
                val uri = Uri.parse("smsto:${item.mobile}")
                val intent = Intent(Intent.ACTION_SENDTO, uri)
                intent.putExtra("sms_body", "the SMS text")
                startActivity(intent)
            }

            callButton.setOnClickListener {
                val uri = Uri.parse("tel:${item.mobile.trim()}")
                val intent = Intent(Intent.ACTION_DIAL, uri)
                startActivity(intent)
            }

            directionButton.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(item.location))
                startActivity(intent)
            }

            shareButton.setOnClickListener {
                val intent = Intent(Intent.ACTION_SEND)
                intent.type = "text/plain"
                intent.putExtra(Intent.EXTRA_SUBJECT, item.name)
                intent.putExtra(Intent.EXTRA_TEXT, "${item.name} ${item.address} ${item.mobile}")
                startActivity(Intent.createChooser(intent, "Choose one"))
            }
        }
    }

    private fun backNavigation() {
        binding.backButton.setOnClickListener {
            onBackPressed()
            finish()
        }
    }

    private fun getDetails() {
        binding.apply {
            special.text = item.special
            doctorName.text = item.name
            patientTextView.text = item.patiens
            bioTextView.text = item.biography
            addressTextVeiw.text = item.address
            dateTextView.text = item.date
            timeTextView.text = item.time
            experienceTextView.text = "${item.expriense} Years"
            ratingTextView.text = "${item.rating}"
            Glide.with(this@DetailActivity).load(item.picture).into(doctorImage)
        }
    }

}