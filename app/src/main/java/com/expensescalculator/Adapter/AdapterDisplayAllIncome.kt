package com.expensescalculator.Adapter

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.expensescalculator.Bean.BeanIncome
import com.expensescalculator.R
import java.util.*

class AdapterDisplayAllIncome(var act: Activity, var arrayAllIncome: ArrayList<BeanIncome>) : BaseAdapter() {
    override fun getCount(): Int {
        return arrayAllIncome.size
    }

    override fun getItem(position: Int): Any {
        return arrayAllIncome[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    private inner class ViewHolder {
        var txtIncDate: TextView? = null
        var txtIncIncome: TextView? = null
        var txtIncCategory: TextView? = null
        var txtIncPayer: TextView? = null
        var txtIncDescription: TextView? = null
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
        var convertView = convertView
        val holder: ViewHolder
        val inflater = act.layoutInflater
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.sp_incomecategory, null)
            holder = ViewHolder()
            holder.txtIncDate = convertView.findViewById<View>(R.id.addincome_tv_Date) as TextView
            holder.txtIncIncome = convertView.findViewById<View>(R.id.addincome_tv_Income) as TextView
            holder.txtIncCategory = convertView.findViewById<View>(R.id.addincome_tv_Category) as TextView
            holder.txtIncPayer = convertView.findViewById<View>(R.id.addincome_tv_Payer) as TextView
            holder.txtIncDescription = convertView.findViewById<View>(R.id.addincome_tv_Discription) as TextView
            convertView.tag = holder
        } else {
            holder = convertView.tag as ViewHolder
        }
        holder.txtIncDate!!.text = arrayAllIncome[position].incDate + ""
        holder.txtIncIncome!!.text = arrayAllIncome[position].incIncome + ""
        holder.txtIncCategory!!.text = arrayAllIncome[position].incCategory + ""
        holder.txtIncPayer!!.text = arrayAllIncome[position].incPayer + ""
        holder.txtIncDescription!!.text = arrayAllIncome[position].incDiscription + ""
        return convertView
    }

}