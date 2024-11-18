package com.example.doctorsappointment.model

import android.os.Parcel
import android.os.Parcelable

data class DoctorsModel(
    val address: String = "",
    val biography: String = "",
    val id: Int = 0,
    val name: String = "",
    val picture: String = "",
    val special: String = "",
    val expriense: Int = 0,
    val cost: String = "",
    val date: String = "",
    val time: String = "",
    val location: String = "",
    val mobile: String = "",
    val patiens: String = "",
    val rating: Double = 0.0,
    val site: String = "",
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readInt(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readInt(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readDouble(),
        parcel.readString().toString()
    ) { }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(address)
        parcel.writeString(biography)
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeString(picture)
        parcel.writeString(special)
        parcel.writeInt(expriense)
        parcel.writeString(cost)
        parcel.writeString(date)
        parcel.writeString(time)
        parcel.writeString(location)
        parcel.writeString(mobile)
        parcel.writeString(patiens)
        parcel.writeDouble(rating)
        parcel.writeString(site)
    }

    companion object CREATOR : Parcelable.Creator<DoctorsModel> {
        override fun createFromParcel(parcel: Parcel): DoctorsModel {
            return DoctorsModel(parcel)
        }

        override fun newArray(size: Int): Array<out DoctorsModel?>? {
            return arrayOfNulls(size)
        }

    }
}