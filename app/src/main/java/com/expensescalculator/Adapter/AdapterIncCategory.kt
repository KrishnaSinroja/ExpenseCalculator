package com.expensescalculator.Adapter

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.expensescalculator.Bean.BeanIncomeCategory
import com.expensescalculator.R
import java.util.*

class AdapterIncCategory(var act: Activity, var arrayIncCategory: ArrayList<BeanIncomeCategory>) : BaseAdapter() {
    override fun getCount(): Int {
        return arrayIncCategory.size
    }

    override fun getItem(position: Int): Any {
        return arrayIncCategory[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    private inner class ViewHolder {
        var txtIncCatID: TextView? = null
        var txtIncCatName: TextView? = null
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
        var convertView = convertView
        val holder: ViewHolder
        val inflater = act.layoutInflater
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.sp_incomecategory, null)
            holder = ViewHolder()
            holder.txtIncCatID = convertView.findViewById<View>(R.id.sp_inccat_tv_id) as TextView
            holder.txtIncCatName = convertView.findViewById<View>(R.id.sp_inccat_tv_name) as TextView
            convertView.tag = holder
        } else {
            holder = convertView.tag as ViewHolder
        }
        holder.txtIncCatID?.setText(arrayIncCategory[position].incCatID.toString())
        holder.txtIncCatName!!.text = arrayIncCategory[position].incCatName + ""
        return convertView
    }

}