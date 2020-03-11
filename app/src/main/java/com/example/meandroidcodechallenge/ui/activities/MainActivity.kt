package com.example.meandroidcodechallenge.ui.activities

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.meandroidcodechallenge.Common.Common
import com.example.meandroidcodechallenge.Common.constants.ApplicationConstants
import com.example.meandroidcodechallenge.R
import com.example.meandroidcodechallenge.model.EmployeeData
import com.example.meandroidcodechallenge.model.EmployeeDetails
import com.example.meandroidcodechallenge.rest.RestClient
import com.example.meandroidcodechallenge.ui.adapters.EmployeeListRecyclerAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity(), EmployeeListRecyclerAdapter.OnItemClickListener {
    private var disposable: Disposable? = null
    private var mAdapter: EmployeeListRecyclerAdapter?= null
    private var mEmployees: MutableList<EmployeeData> = ArrayList()

    private val client by lazy {
        RestClient.create()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        try {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            setupRecycler()
            fetchEmployeeDataList()

            swipeRefreshLayout!!.setOnRefreshListener {
                mEmployees.clear()
                mAdapter!!.notifyDataSetChanged()
                fetchEmployeeDataList()
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

    private fun setupRecycler() {
        employeeListRecyclerView!!.setHasFixedSize(true)
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        employeeListRecyclerView!!.layoutManager = layoutManager

        mAdapter = EmployeeListRecyclerAdapter(this, mEmployees, R.layout.row_empployee_list_item_view)
        employeeListRecyclerView!!.adapter = mAdapter
    }

    private fun fetchEmployeeDataList() {
        if (Common.isNetworkConnected(this)) {
            Common.showLoading(this)
            disposable = client.fetchEmployeeData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { result ->
                        Common.hideLoading()
                        swipeRefreshLayout!!.isRefreshing = false
                        mEmployees.addAll(result!!)
                        mAdapter!!.notifyDataSetChanged()
                        if(result.isNotEmpty()){
                            toggleView(false)
                        }
                    },
                    { error ->
                        Common.hideLoading()
                        swipeRefreshLayout!!.isRefreshing = false
                        Common.showLongToast(this, error.message.toString())
                        toggleView(true)
                        Log.e("ERROR", error.message)
                    }
                )
        } else {
            swipeRefreshLayout!!.isRefreshing = false
            toggleView(true)
            Common.hideLoading()
            Common.showSnackBar(ApplicationConstants.NETWORK_ERROR, ContextCompat.getColor(this, R.color.red), this)
        }
    }

    override fun onItemClicked(employee: EmployeeData) {
        val mDetails = employee.id?.let { EmployeeDetails(it) }
        val intent = Intent(this, EmployeeDetailsActivity::class.java)
        intent.putExtra("employee_data", mDetails)
        startActivity(intent)
    }

    private fun toggleView(isFeedEmpty: Boolean) {
        if (isFeedEmpty) {
            emptyFeed!!.visibility = View.VISIBLE
            employeeListRecyclerView!!.visibility = View.GONE
        } else {
            emptyFeed!!.visibility = View.GONE
            employeeListRecyclerView!!.visibility = View.VISIBLE
        }
    }

    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }
}
