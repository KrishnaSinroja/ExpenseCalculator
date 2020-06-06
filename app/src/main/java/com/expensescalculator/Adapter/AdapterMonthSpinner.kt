package com.expensescalculator.Adapter

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.expensescalculator.Bean.BeanMonth
import com.expensescalculator.R
import java.util.*

class AdapterMonthSpinner(var act: Activity, var arrayMonth: ArrayList<BeanMonth>) : BaseAdapter() {
    override fun getCount(): Int {
        return arrayMonth.size
    }

    override fun getItem(position: Int): Any {
        return arrayMonth[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    private inner class ViewHolder {
        var txtMonthID: TextView? = null
        var txtMonthName: TextView? = null
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
        var convertView = convertView
        val holder: ViewHolder
        val inflater = act.layoutInflater
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.sp_month, null)
            holder = ViewHolder()
            holder.txtMonthID = convertView.findViewById<View>(R.id.sp_expcat_tv_id) as TextView
            holder.txtMonthName = convertView.findViewById<View>(R.id.sp_expcat_tv_name) as TextView
            convertView.tag = holder
        } else {
            holder = convertView.tag as ViewHolder
        }
        holder.txtMonthID
                ?.setText(arrayMonth[position].monthID.toString())
        holder.txtMonthName!!.text = arrayMonth[position].monthName + ""
        return convertView
    }

}