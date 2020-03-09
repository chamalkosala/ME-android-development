package com.example.meandroidcodechallenge.ui.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.meandroidcodechallenge.Common.Common
import com.example.meandroidcodechallenge.Common.constants.ApplicationConstants
import com.example.meandroidcodechallenge.R
import com.example.meandroidcodechallenge.model.Employee
import com.example.meandroidcodechallenge.model.EmployeeData
import com.example.meandroidcodechallenge.model.EmployeeDetails
import com.example.meandroidcodechallenge.rest.APIService
import com.example.meandroidcodechallenge.rest.RestClient
import com.example.meandroidcodechallenge.ui.adapters.EmployeeListRecyclerAdapter
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*


class MainActivity : BaseActivity(), EmployeeListRecyclerAdapter.OnItemClickListener {
    private var listProgress: ProgressBar? = null
    private var mApiService: APIService? = null
    private var mAdapter: EmployeeListRecyclerAdapter?= null
    private var mEmployees: MutableList<EmployeeData> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mApiService = RestClient.client.create(APIService::class.java)
        listProgress = progressBar
        employeeListRecyclerView!!.layoutManager = LinearLayoutManager(this)
        mAdapter = EmployeeListRecyclerAdapter(this, mEmployees, R.layout.row_empployee_list_item_view)
        employeeListRecyclerView!!.adapter = mAdapter

        fetchEmployeeDataList()
    }

    private fun fetchEmployeeDataList() {
        if (Common.isNetworkConnected(this)) {
            performGetEmployeeList()
        } else {
            listProgress!!.setVisibility(View.GONE)
            showAlertDialog(
                ApplicationConstants.WARNING,
                ApplicationConstants.ERROR_MSG_CONNECTION_LOST
            )
        }
    }

    private fun performGetEmployeeList() {
        val call = mApiService!!.fetchEmployeeData()
        call.enqueue(object : Callback<Employee> {
            override fun onResponse(call: Call<Employee>, response: Response<Employee>) {
                listProgress!!.setVisibility(View.GONE)
                val employee = response.body()
                if (employee != null) {
                    mEmployees.addAll(employee.data!!)
                    mAdapter!!.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<Employee>, t: Throwable) {
                listProgress!!.setVisibility(View.GONE)
                Log.e(TAG, "Got error : " + t.localizedMessage)
            }
        })
    }

    override fun onItemClicked(employee: EmployeeData) {
        val mDetails = EmployeeDetails(employee.employee_name.toString(), employee.employee_age.toString())
        val intent = Intent(this, EmployeeDetailsActivity::class.java)
        intent.putExtra("employee_data", mDetails)
        startActivity(intent)
    }

    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }
}
