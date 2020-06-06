package com.expensescalculator.Design

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListAdapter
import android.widget.ExpandableListView
import com.expensescalculator.Adapter.AdapterExpandableInc
import com.expensescalculator.Bean.BeanIncome
import com.expensescalculator.DBhelper.DB_Income
import com.expensescalculator.DBhelper.DB_IncomeCategory
import com.expensescalculator.R
import java.util.*


class Income : Fragment() {
    var listAdapter: ExpandableListAdapter? = null
    var incListView: ExpandableListView? = null

    //    ListView expListView;
    var listDataHeader: MutableList<String>? = null
    var listDataChild: HashMap<String, List<String>>? = null
    var arrayDistinctMonth: ArrayList<BeanIncome>? = null
    var arrayAllIncome: ArrayList<BeanIncome>? = null
    var dbi: DB_Income? = null
    var dbic: DB_IncomeCategory? = null
    var bi: BeanIncome? = null
    var Month1 = ""
    var Category = ""
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootview = inflater.inflate(R.layout.activity_expense, container, false)

        // get the listview
        incListView = rootview.findViewById<View>(R.id.lvExp) as ExpandableListView

        // preparing list data
        //prepareListData();
        listDataHeader = ArrayList()
        listDataChild = HashMap()
        dbi = DB_Income(this.activity)
        bi = BeanIncome()
        dbic = DB_IncomeCategory(this.activity)
        arrayDistinctMonth = ArrayList()
        arrayDistinctMonth = dbi!!.selectDistinctMonth()
        for (i in arrayDistinctMonth!!.indices) {
            (listDataHeader as ArrayList<String>).add(arrayDistinctMonth!!.get(i).incMonth + "")
            //listDataHeader.add(arrayDistinctMonth.get(1).getExpMonth()+"");
        }
        for (k in arrayDistinctMonth!!.indices) {
            Month1 = arrayDistinctMonth!!.get(k).incMonth.toString()
            arrayAllIncome = dbi!!.selectAllIIncome(Month1)
            val allInc: MutableList<String> = ArrayList()
            for (j in arrayAllIncome!!.indices) {
                val strCat = arrayAllIncome!!.get(j).incCatID.toString() + ""
                val strCatName = dbic!!.selectById(strCat.toInt())
                allInc.add(strCatName)
                allInc.add(arrayAllIncome!!.get(j).incDate + "")
                allInc.add(arrayAllIncome!!.get(j).incIncome + "")

//
            }
            listDataChild!![arrayDistinctMonth!!.get(k).incMonth + ""] = allInc
            listAdapter = AdapterExpandableInc(activity, listDataHeader as ArrayList<String>, listDataChild!!, allInc)
            // setting list adapter
            incListView!!.setAdapter(listAdapter)
        }
        return rootview
    }
}