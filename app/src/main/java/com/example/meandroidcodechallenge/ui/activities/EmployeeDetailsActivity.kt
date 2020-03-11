package com.example.meandroidcodechallenge.ui.activities

import android.annotation.SuppressLint
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Bundle
import android.util.Base64
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.meandroidcodechallenge.Common.Common
import com.example.meandroidcodechallenge.Common.constants.ApplicationConstants
import com.example.meandroidcodechallenge.R
import com.example.meandroidcodechallenge.model.EmployeeData
import com.example.meandroidcodechallenge.model.EmployeeDetails
import com.example.meandroidcodechallenge.rest.RestClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_employee_detail.*

class EmployeeDetailsActivity : AppCompatActivity() {

    private var disposable: Disposable? = null
    private val client by lazy {
        RestClient.create()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        try {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_employee_detail)

            val mEmployeeData: EmployeeDetails? = intent.getParcelableExtra("employee_data")

            if (mEmployeeData != null) {
                fetchEmployeeDataByID(mEmployeeData.id)
            } else toggleView(true)

            swipeRefreshLayout.setOnRefreshListener {
                if (mEmployeeData != null) {
                    fetchEmployeeDataByID(mEmployeeData.id)
                } else toggleView(true)
            }

            //** Set the colors of the Pull To Refresh View
            swipeRefreshLayout!!.setProgressBackgroundColorSchemeColor( ContextCompat.getColor(this, R.color.colorPrimary))
            swipeRefreshLayout!!.setColorSchemeColors(Color.WHITE)

            Log.d(TAG, "onCreate")
        } catch (e: Exception) {
            Log.e(TAG, "onCreate: $e")
        }
    }

    override fun onPause() {
        super.onPause()
        disposable?.dispose()
    }

    override fun onDestroy() {
        Common.hideLoading()
        super.onDestroy()
    }

    @SuppressLint("SetTextI18n")
    private fun setEmployeeDetails(employee: EmployeeData?) {
        val empImage = ivEmpImage
        val empName = tvEmpName
        val empAge = tvEmpAge
        val empBirthDay = tvBirthDay

        var base64String: String = "";
        if (employee?.image != null) base64String = employee.image
        else if (employee?.thumbImage != null) base64String = employee.thumbImage

        if (base64String.isNotEmpty()) {
            val imageBytes = Base64.decode(base64String, Base64.DEFAULT)
            val decodedImage = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size)
            empImage?.setImageBitmap(decodedImage)
        }

        var employeeName: String = "";
        if (employee?.first_name != null) employeeName = employee.first_name

        if (employee?.last_name != null) {
            employeeName = if (employeeName.isNotEmpty()) employeeName + " " + employee.last_name
            else employee.last_name
        }

        empName?.text = employeeName
        empAge?.text = employee?.gender
        empBirthDay?.text = employee?.birth_date
    }

    private fun fetchEmployeeDataByID(id: Int) {
        if (Common.isNetworkConnected(this)) {
            Common.showLoading(this)
            disposable = client.fetchEmployeeDataByID(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { result ->
                        Common.hideLoading()
                        swipeRefreshLayout.isRefreshing = false
                        toggleView(false)
                        setEmployeeDetails(result)
                    },
                    { error ->
                        Common.hideLoading()
                        swipeRefreshLayout.isRefreshing = false
                        Common.showLongToast(this, error.message.toString())
                        toggleView(true)
                        Log.e("ERROR", error.message)
                    }
                )
        } else {
            swipeRefreshLayout.isRefreshing = false
            toggleView(true)
            Common.hideLoading()
            Common.showSnackBar(ApplicationConstants.NETWORK_ERROR, ContextCompat.getColor(this, R.color.red),this)
        }
    }

    private fun toggleView(isFeedEmpty: Boolean) {
        if (isFeedEmpty) {
            emptyMsg!!.visibility = View.VISIBLE
            mainContainer!!.visibility = View.GONE
        } else {
            emptyMsg!!.visibility = View.GONE
            mainContainer!!.visibility = View.VISIBLE
        }
    }

    companion object {
        private val TAG = EmployeeDetailsActivity::class.java.simpleName
    }
}
