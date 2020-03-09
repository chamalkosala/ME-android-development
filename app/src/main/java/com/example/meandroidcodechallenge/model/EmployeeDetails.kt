package com.example.meandroidcodechallenge.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class EmployeeDetails(val name: String, val age: String) : Parcelable