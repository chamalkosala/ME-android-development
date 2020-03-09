package com.example.meandroidcodechallenge.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.meandroidcodechallenge.Common.constants.ApplicationConstants
import com.example.meandroidcodechallenge.R
import com.example.meandroidcodechallenge.model.EmployeeData
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.employee_list_item_view.view.*

class EmployeeListRecyclerAdapter(
    val itemClickListener: OnItemClickListener,
    private val mEmployee: List<EmployeeData>,
    private val mRowLayout: Int
) : RecyclerView.Adapter<EmployeeListRecyclerAdapter.EmployeeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(mRowLayout, parent, false)
        return EmployeeViewHolder(view)
    }

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {
        val employee = mEmployee.get(position)
        holder.bind(employee, itemClickListener)
    }

    override fun getItemCount(): Int {
        return mEmployee.size
    }

    class EmployeeViewHolder(val containerView: View) : RecyclerView.ViewHolder(containerView) {
        val imgProgress = containerView.imageProgress
        val empImage = containerView.ivEmpImage;
        val empName = containerView.tvEmpName;
        val empGender = containerView.tvEmpGender;
        val empBirthDay = containerView.tvEmpBirthDate;

        fun bind(employee: EmployeeData, clickListener: OnItemClickListener) {
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
            empName?.text = employee.employee_name
            empGender?.text = employee.employee_age
            empBirthDay?.text = employee.employee_salary

            itemView.setOnClickListener {
                clickListener.onItemClicked(employee)
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClicked(employee: EmployeeData)
    }
}
