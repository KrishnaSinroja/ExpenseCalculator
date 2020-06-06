package com.expensescalculator.Design

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListAdapter
import android.widget.ExpandableListView
import android.widget.Toast
import com.expensescalculator.Adapter.AdapterExpandableExp
import com.expensescalculator.Bean.BeanExpChild
import com.expensescalculator.Bean.BeanExpParent
import com.expensescalculator.Bean.BeanExpense
import com.expensescalculator.DBhelper.DB_Expense
import com.expensescalculator.DBhelper.DB_ExpenseCategory
import com.expensescalculator.DBhelper.DB_Month
import com.expensescalculator.R
import java.util.*


class Expense : Fragment() {
    var listAdapter: ExpandableListAdapter? = null
    var expListView: ExpandableListView? = null

    //    ListView expListView;
    var listDataHeader: MutableList<String>? = null
    var listDataChild: HashMap<String, List<String>>? = null
    var arrayDistinctMonth: ArrayList<BeanExpense>? = null
    var arrayAllExpense: ArrayList<BeanExpense>? = null
    var dbe: DB_Expense? = null
    var dbec: DB_ExpenseCategory? = null
    var dbm: DB_Month? = null
    var be: BeanExpense? = null
    var Month1 = ""
    var getRecords = ArrayList<BeanExpense>()
    var Month2 = ""
    var Category = ""
    var bep: BeanExpParent? = null
    var bec: BeanExpChild? = null
    var child: BeanExpChild? = null
    var parents: ArrayList<BeanExpParent>? = null
    var arraychild: ArrayList<BeanExpChild>? = null
    var MonthName = ""
    var MonthID = ""
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootview = inflater.inflate(R.layout.activity_expense, container, false)
        expListView = rootview.findViewById<View>(R.id.lvExp) as ExpandableListView
        listDataHeader = ArrayList()
        listDataChild = HashMap()
        dbe = DB_Expense(this.activity)
        dbm = DB_Month(this.activity)
        be = BeanExpense()
        dbec = DB_ExpenseCategory(this.activity)
        bep = BeanExpParent()
        bec = BeanExpChild()
        child = BeanExpChild()
        arrayDistinctMonth = ArrayList()
        parents = ArrayList()
        arraychild = ArrayList()
        val list = ArrayList<BeanExpParent>()
        var li = ArrayList<BeanExpense?>()
        val d = DB_Expense(container!!.context)
        li = d.selectAllIExpense("March")
        Log.v("", "DBEXPSize-->" + li.size)

        // listDataHeader = new ArrayList<String>();
        // listDataChild = new HashMap<String, List<String>>();

        // Adding child data

        //listDataHeader.add(Month);

//        arrayDistinctMonth=dbe.selectAllIExpense();
//
//        for(int i =0;i<arrayDistinctMonth.size();i++)
//        {
//            Month[i]=arrayDistinctMonth.get(i).toString();
//            listDataHeader.add(Month[i]);
//        }

        //Code for distinct month wise record starts from here
        arrayDistinctMonth = dbe!!.selectDistinctMonth()
        for (i in arrayDistinctMonth!!.indices) {
            (listDataHeader as ArrayList<String>).add(arrayDistinctMonth!!.get(i).expMonth + "")

//            MonthID=arrayDistinctMonth.get(i).getExpMonth() + "";
//            MonthName=dbm.selectById(MonthID);
//            listDataHeader.add(MonthName);
//            bep.setMonth(arrayDistinctMonth.get(i).getExpMonth()+"");
//            parents.add(bep);
        }
        val strdemo = ""
        var expdata: Array<String?>
        for (k in arrayDistinctMonth!!.indices) {
//            Month1=arrayDistinctMonth.get(k).getExpMonth();
//            Month2=dbm.selectById(Month1);
//            arrayAllExpense=dbe.selectAllIExpense(Month1);
            Month1 = arrayDistinctMonth!!.get(k).expMonth.toString()
            var arrayAllExpense = dbe!!.selectAllIExpense(Month1)
            val allExp: MutableList<String> = ArrayList()
            val childrecord = ArrayList<BeanExpChild>()
            for (j in arrayAllExpense.indices) {
                val strCat = arrayAllExpense.get(j)?.expCatID.toString() + ""
                val strCatName = dbec!!.selectById(strCat.toInt())
                allExp.add(strCatName)
                allExp.add(arrayAllExpense.get(j)?.expDate + "")
                allExp.add(arrayAllExpense.get(j)?.expExpense + "")


                // strdemo += strCat;
                //strdemo = strdemo+ strCatName+":";
                //allExp.add(strdemo);
                // bep.setCategory(strCatName);
                // bec.setCategory(strCatName);
                //bec.getChildren().add(bec);
                //arraychild.add(bec);
                // parents.add(bep);

                //bep.getChildren().add(child);


                //strdemo = strdemo+ arrayAllExpense.get(j).getExpDate()+":";
                //allExp.add(strdemo);
                //bep.setDate(arrayAllExpense.get(j).getExpDate() + "");
                //bep.getChildren().add(child);
                //bec.setDate(arrayAllExpense.get(j).getExpDate() + "");
                // bec.getChildren().add(bec);
                //arraychild.add(bec);
                // parents.add(bep);


                //strdemo = strdemo+arrayAllExpense.get(j).getExpExpense()+":";
                //allExp.add(strdemo);
                //strdemo.toCharArray();
                //bep.setExpense(arrayAllExpense.get(j).getExpExpense() + "");
                //childrecord.add(child);
                //bec.setExpense(arrayAllExpense.get(j).getExpExpense() + "");
                //bec.getChildren().add(bec);
                //arraychild.add(bec);

//                bep.setChildren(childrecord);
//
            }
            getRecords = dbe!!.allRecords
            listAdapter = AdapterExpandableExp(activity, listDataHeader as ArrayList<String>, getRecords, allExp, parents!!, arraychild!!, strdemo)
            expListView!!.setAdapter(listAdapter)

            //setting list adapter
            //expListView.setAdapter(listAdapter);
        }
        expListView!!.setOnChildClickListener { parent, v, groupPosition, childPosition, id ->
            Toast.makeText(activity.applicationContext, "Child IS Clikced", Toast.LENGTH_SHORT).show()
            false
        }
        return rootview

//        arrayDistinctMonth=dbe.selectDistinctMonth();
//        for(int i=0;i<arrayDistinctMonth.size();i++)
//        {
//            listDataHeader.add(arrayDistinctMonth.get(i).getExpMonth()+"");
//            //listDataHeader.add(arrayDistinctMonth.get(1).getExpMonth()+"");
//        }
//
//
//        arrayAllExpense=dbe.selectAllIExpense();
//        List<String> allExp = new ArrayList<String>();
//        for(int j=0;j<arrayAllExpense.size();j++)
//        {
//
//                allExp.add("Date = "+arrayAllExpense.get(j).getExpDate()+"");
//                allExp.add("Expense = "+arrayAllExpense.get(j).getExpExpense()+"");
//                allExp.add("Category = "+arrayAllExpense.get(j).getExpCatID()+"");
//                allExp.add("Payee = "+arrayAllExpense.get(j).getExpPayee()+"");
//                allExp.add("Description = "+arrayAllExpense.get(j).getExpDiscription()+"");
//
//        }
//
//        for (int k=0;k<arrayDistinctMonth.size();k++)
//        {
//            listDataChild.put(arrayDistinctMonth.get(k).getExpMonth()+"",allExp);
//
//        }
//
//
    }
}