package com.example.meandroidcodechallenge.ui.activities

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.meandroidcodechallenge.Common.constants.ApplicationConstants
import com.example.meandroidcodechallenge.R
import com.example.meandroidcodechallenge.model.EmployeeDetails
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_employee_detail.*

class EmployeeDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee_detail)

        val mEmployeeData: EmployeeDetails? = intent.getParcelableExtra("employee_data")

        setEmployeeDetails(mEmployeeData);
    }

    @SuppressLint("SetTextI18n")
    private fun setEmployeeDetails(mEmployeeData: EmployeeDetails?) {
        val imgProgress = imageProgress
        val empImage = ivEmpImage
        val empName = tvEmpName
        val empAge = tvEmpAge

        Picasso.get()
            .load(ApplicationConstants.EMP_PROF_IMAGE)
            .into(empImage, object : Callback {
                override fun onSuccess() {
                    imgProgress.setVisibility(View.GONE)
                }

                override fun onError(e: Exception?) {
                    imgProgress.setVisibility(View.GONE)
                    empImage.setImageResource(R.drawable.ic_default_user)
                }
            })

        empName?.text = mEmployeeData!!.name
        empAge?.text = this.getString(R.string.emp_age) + " " + mEmployeeData.age
    }
}
