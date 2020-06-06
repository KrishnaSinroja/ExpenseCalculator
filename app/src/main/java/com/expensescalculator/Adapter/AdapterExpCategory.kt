package com.expensescalculator.Adapter

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.expensescalculator.Bean.BeanExpenseCategory
import com.expensescalculator.R
import java.util.*

class AdapterExpCategory(var act: Activity, var arrayExpCategory: ArrayList<BeanExpenseCategory>) : BaseAdapter() {
    override fun getCount(): Int {
        return arrayExpCategory.size
    }

    override fun getItem(position: Int): Any {
        return arrayExpCategory[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    private inner class ViewHolder {
        var txtExpCatID: TextView? = null
        var txtExpCatName: TextView? = null
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
        var convertView = convertView
        val holder: ViewHolder
        val inflater = act.layoutInflater
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.sp_expensecategory, null)
            holder = ViewHolder()
            holder.txtExpCatID = convertView.findViewById<View>(R.id.sp_expcat_tv_id) as TextView
            holder.txtExpCatName = convertView.findViewById<View>(R.id.sp_expcat_tv_name) as TextView
            convertView.tag = holder
        } else {
            holder = convertView.tag as ViewHolder
        }
        holder.txtExpCatID?.setText(arrayExpCategory[position].expCatID.toString())
        holder.txtExpCatName!!.text = arrayExpCategory[position].expCatName + ""
        return convertView
    }

}