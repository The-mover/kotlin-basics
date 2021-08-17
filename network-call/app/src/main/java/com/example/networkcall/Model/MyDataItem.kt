package com.example.networkcall.Model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MyDataItem(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
) : Parcelable