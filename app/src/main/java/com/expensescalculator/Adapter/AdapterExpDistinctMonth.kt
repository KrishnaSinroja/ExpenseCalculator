package com.expensescalculator.Adapter

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.expensescalculator.Bean.BeanExpense
import com.expensescalculator.R
import java.util.*

class AdapterExpDistinctMonth(var act: Activity, var arrayDistinctMonth: ArrayList<BeanExpense>) : BaseAdapter() {
    override fun getCount(): Int {
        return arrayDistinctMonth.size
    }

    override fun getItem(position: Int): Any {
        return arrayDistinctMonth[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    private inner class ViewHolder {
        var txtExpMonth: TextView? = null
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
        var convertView = convertView
        val holder: ViewHolder
        val inflater = act.layoutInflater
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.sp_expensecategory, null)
            holder = ViewHolder()
            holder.txtExpMonth = convertView.findViewById<View>(R.id.lblListHeader) as TextView
            convertView.tag = holder
        } else {
            holder = convertView.tag as ViewHolder
        }
        holder.txtExpMonth!!.text = arrayDistinctMonth[position].expMonth + ""
        return convertView
    }

}