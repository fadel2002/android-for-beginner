package com.example.finalproject.phone

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Phone (
    var name: String = "",
    var photo: String = "",
    var price: String = "",
    var display: String = "",
    var size: String = "",
    var battery: String = "",
    var gpu: String = "",
    var cpu: String = "",
    var seller: String = ""
) : Parcelable