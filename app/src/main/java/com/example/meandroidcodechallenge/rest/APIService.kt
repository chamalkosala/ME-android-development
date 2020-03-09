package com.example.meandroidcodechallenge.rest

import com.example.meandroidcodechallenge.model.Employee
import retrofit2.Call
import retrofit2.http.GET

interface APIService {
    @GET("/api/v1/employees")    //End Url
    fun fetchEmployeeData(): Call<Employee>
}