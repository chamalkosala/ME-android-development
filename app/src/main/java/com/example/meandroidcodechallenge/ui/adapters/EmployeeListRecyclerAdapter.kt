package com.example.meandroidcodechallenge.ui.adapters

import android.graphics.BitmapFactory
import android.util.Base64
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.meandroidcodechallenge.model.EmployeeData
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
            var base64String: String = "";
            if (employee.thumbImage != null) {
                base64String = employee.thumbImage
            } else if (employee.image != null)
                base64String = employee.image

            if (base64String.isNotEmpty()) {
                val imageBytes = Base64.decode(base64String, Base64.DEFAULT)
                val decodedImage = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size)
                empImage?.setImageBitmap(decodedImage)
            }

            var employeeName: String = "";
            if (employee.first_name != null) {
                employeeName = employee.first_name
            }
            if (employee.last_name != null) {
                employeeName =
                    if (employeeName.isNotEmpty()) employeeName + " " + employee.last_name
                    else employee.last_name
            }

            empName?.text = employeeName
            empGender?.text = employee.gender
            empBirthDay?.text = employee.birth_date

            itemView.setOnClickListener {
                clickListener.onItemClicked(employee)
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClicked(employee: EmployeeData)
    }
}
