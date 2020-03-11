package com.example.meandroidcodechallenge.rest

import com.example.meandroidcodechallenge.model.EmployeeData
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface APIService {
    @GET("/employees")    //End Url
    fun fetchEmployeeData(): Single<List<EmployeeData>>

    @GET("/employees/{id}")    //End Url
    fun fetchEmployeeDataByID(@Path("id") id: Int): Single<EmployeeData>
}