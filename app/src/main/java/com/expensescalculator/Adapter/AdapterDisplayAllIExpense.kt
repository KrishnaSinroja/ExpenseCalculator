package com.expensescalculator.Adapter

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.expensescalculator.Bean.BeanExpense
import com.expensescalculator.R
import java.util.*

class AdapterDisplayAllIExpense(var act: Activity, var arrayAllExpense: ArrayList<BeanExpense>) : BaseAdapter() {
    override fun getCount(): Int {
        return arrayAllExpense.size
    }

    override fun getItem(position: Int): Any {
        return arrayAllExpense[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    private inner class ViewHolder {
        var txtExpDate: TextView? = null
        var txtExpIncome: TextView? = null
        var txtExpCategory: TextView? = null
        var txtExpPayee: TextView? = null
        var txtExpDescription: TextView? = null
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
        var convertView = convertView
        val holder: ViewHolder
        val inflater = act.layoutInflater
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.sp_expensecategory, null)
            holder = ViewHolder()
            holder.txtExpDate = convertView.findViewById<View>(R.id.addexpense_tv_Date) as TextView
            holder.txtExpIncome = convertView.findViewById<View>(R.id.addexpense_tv_expense) as TextView
            holder.txtExpCategory = convertView.findViewById<View>(R.id.addexpense_tv_Category) as TextView
            holder.txtExpPayee = convertView.findViewById<View>(R.id.addexpense_tv_Payee) as TextView
            holder.txtExpDescription = convertView.findViewById<View>(R.id.addexpense_ed_discription) as TextView
            convertView.tag = holder
        } else {
            holder = convertView.tag as ViewHolder
        }
        holder.txtExpDate!!.text = arrayAllExpense[position].expDate + ""
        holder.txtExpIncome!!.text = arrayAllExpense[position].expExpense + ""
        holder.txtExpCategory!!.text = arrayAllExpense[position].expCategory + ""
        holder.txtExpPayee!!.text = arrayAllExpense[position].expPayee + ""
        holder.txtExpDescription!!.text = arrayAllExpense[position].expDiscription + ""
        return convertView
    }

}