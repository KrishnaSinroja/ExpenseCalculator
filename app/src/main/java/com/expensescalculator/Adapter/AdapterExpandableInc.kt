package com.expensescalculator.Adapter

import android.content.Context
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView
import com.expensescalculator.R
import java.util.*

class AdapterExpandableInc(private val _context: Context, // header titles
                           private val _listDataHeader: List<String>,
        // child data in format of header title, child title
                           private val _listDataChild: HashMap<String, List<String>>, private val allInc: List<String>) : BaseExpandableListAdapter() {

    override fun getChild(groupPosition: Int, childPosititon: Int): Any {
        return _listDataChild[_listDataHeader[groupPosition]]?.get(childPosititon / 3)!!
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return (childPosition / 3).toLong()
    }

    override fun getChildView(groupPosition: Int, childPosition: Int,
                              isLastChild: Boolean, convertView: View?, parent: ViewGroup): View? {


//        final String childText1 = (String) getChild(groupPosition, childPosition);
//        final String childText2 = (String) getChild(groupPosition, childPosition);
//        final String childText3 = (String) getChild(groupPosition, childPosition);
        var convertView = convertView
        if (convertView == null) {
            val infalInflater = _context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = infalInflater.inflate(R.layout.lst_item_income, null)
        }
        val txtListChildCategory = convertView
                ?.findViewById<View>(R.id.lblListCategory) as TextView
        val txtListChildDate = convertView
                ?.findViewById<View>(R.id.lblListDate) as TextView
        val txtListChildIncome = convertView
                ?.findViewById<View>(R.id.lblListIncome) as TextView
        //

//        String childText1 = (String) getChild(groupPosition, childPosition);
//        txtListChildCategory.setText(childText1);
//
//        childText1 = (String) getChild(groupPosition, childPosition);
//        txtListChildDate.setText(childText1);
//
//        childText1 = (String) getChild(groupPosition, childPosition);
//        txtListChildIncome.setText(childText1);

//        for(int i=0;i<allInc.size();i++)
//        {
//            txtListChildCategory.setText(allInc.get(i));
//            txtListChildDate.setText(allInc.get(i+1));
//           // txtListChildIncome.setText(allInc.get(i+2));
//        }

//        txtListChildCategory.setText(allInc.get(0));
//        txtListChildDate.setText(allInc.get(1));
//        txtListChildIncome.setText(allInc.get(2));


//
        var i = 0
        while (i < allInc.size) {
            txtListChildCategory.text = allInc[i]
            txtListChildDate.text = allInc[i + 1]
            txtListChildIncome.text = allInc[i + 2]
            i += 3
        }
        return convertView
    }

    override fun getChildrenCount(groupPosition: Int): Int {
        return _listDataChild[_listDataHeader[groupPosition]]!!.size / 3
    }

    override fun getGroup(groupPosition: Int): Any {
        return _listDataHeader[groupPosition]
    }

    override fun getGroupCount(): Int {
        return _listDataHeader.size
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getGroupView(groupPosition: Int, isExpanded: Boolean,
                              convertView: View?, parent: ViewGroup): View? {
        var convertView = convertView
        val headerTitle = getGroup(groupPosition) as String
        if (convertView == null) {
            val infalInflater = _context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = infalInflater.inflate(R.layout.lst_grp_income, null)
        }
        val lblListHeader = convertView
                ?.findViewById<View>(R.id.lblListHeader) as TextView
        lblListHeader.setTypeface(null, Typeface.BOLD)
        lblListHeader.text = headerTitle
        return convertView
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return true
    }

}