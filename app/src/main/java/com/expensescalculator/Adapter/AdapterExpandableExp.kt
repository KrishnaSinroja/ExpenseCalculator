package com.expensescalculator.Adapter

import android.content.Context
import android.graphics.Typeface
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView
import com.expensescalculator.Bean.BeanExpChild
import com.expensescalculator.Bean.BeanExpParent
import com.expensescalculator.Bean.BeanExpense
import com.expensescalculator.R
import java.util.*
import kotlin.collections.ArrayList

class AdapterExpandableExp(private val _context: Context, // header titles
                           private val _listDataHeader: List<String>,
        // child data in format of header title, child title
                           private val _listDataChild: ArrayList<BeanExpense>, private val allExp: List<String>, var parents: ArrayList<BeanExpParent>,
                           arrayChild: ArrayList<BeanExpChild>, strdemo: String) : BaseExpandableListAdapter() {

    //private List<String> allExpData;
    var arrayAllExpense: ArrayList<BeanExpense>? = null
    var category = ""
    var date = ""
    var expense = ""
    var be = BeanExpense()
    var bep: BeanExpParent
    var list: ArrayList<BeanExpParent>
    var arrayChild: ArrayList<BeanExpChild>
    var parentdetai: BeanExpParent
    var bec: BeanExpChild
    var childdetail: BeanExpChild
    var strdemo: String
    override fun getChild(groupPosition: Int, childPosititon: Int): Any {
        return _listDataChild[groupPosition]
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return (childPosition / 3).toLong()
    }

    override fun getChildView(groupPosition: Int, childPosition: Int,
                              isLastChild: Boolean, convertView: View?, parent: ViewGroup): View? {


        //final String childText1 = (String) getChild(groupPosition, childPosition);
        //final String childText2 = (String) getChild(groupPosition, childPosition);
        //final String childText3 = (String) getChild(groupPosition, childPosition);
        var convertView = convertView
        if (convertView == null) {
            val infalInflater = _context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = infalInflater.inflate(R.layout.lst_item_expense, null)
        }
        val txtListChildCategory = convertView
                ?.findViewById<View>(R.id.lblListCategory) as TextView
        val txtListChildDate = convertView
                ?.findViewById<View>(R.id.lblListDate) as TextView
        val txtListChildExpense = convertView
                .findViewById<View>(R.id.lblListExpense) as TextView
        //

        //childdetail=parents.get(groupPosition).getChildren().get(childPosition);

//        BeanExpChild bec=new BeanExpChild();
//        bec=
        //childdetail=bep.getChildren().get(childPosition);

        // BeanExpChild bec=parents.get(groupPosition).getChildren().get(childPosition);


//        for (int i = 0;i<allExp.size();i+=3){
//            txtListChildCategory.setText(allExp.get(i));
//            txtListChildDate.setText(allExp.get(i+1));
//            txtListChildExpense.setText(allExp.get(i+2));
//        }


//        for(int j=0;j<strdemo.length();j++)
//        {
//
//            txtListChildCategory.setText(expdata[j]);
//            txtListChildDate.setText(expdata[j+1]);
//            txtListChildExpense.setText(expdata[j+2]);
//
//        }


//        for(int i=0;i<expdata.length;i+=3)
//        {
//            txtListChildCategory.setText(expdata[i]);
//            txtListChildDate.setText(expdata[i+1]);
//            txtListChildExpense.setText(expdata[i+2]);
//
//        }
        Log.v("-------------->>", _listDataHeader[groupPosition])
        if (_listDataChild[childPosition].expMonth == _listDataHeader[groupPosition]) {
            txtListChildCategory.text = _listDataChild[childPosition].expCategory
            txtListChildDate.text = _listDataChild[childPosition].expDate
            txtListChildExpense.text = _listDataChild[childPosition].expExpense
        }


//                for(int i=0;i<_listDataChild.size();i++)
//                {
//                    if(_listDataChild.get(childPosition).getExpMonth().equals(_listDataHeader.get(groupPosition))) {
//
//                        txtListChildCategory.setText(_listDataChild.get(childPosition).getExpCategory());
//                        txtListChildDate.setText(_listDataChild.get(childPosition).getExpDate());
//                        txtListChildExpense.setText(_listDataChild.get(childPosition).getExpExpense());
//                    }
//
//                }


//        Set<Map.Entry<String, ArrayList<String>>> setMap = _listDataChild.entrySet();
//        // Get an iterator
//        Iterator<Map.Entry<String,  ArrayList<String>>> iteratorMap = setMap.iterator();
//
//
//       //System.out.println("\nHashMap with Multiple Values");
//        // display all the elements
//
//        while(iteratorMap.hasNext()) {
//            Map.Entry<String, ArrayList<String>> entry =
//                    (Map.Entry<String, ArrayList<String>>) iteratorMap.next();
//
//            String key = entry.getKey();
//            List<String> values = entry.getValue();
//            // System.out.println("Key = '" + key + "' has values: " + values);
//
//
//
//            int k=childPosition=0;
//
//            for(int i=0;i<values.size();i++)
//            {
////
//                for(int j=0;j<_listDataHeader.size();j++)
//                {
//                    String header=_listDataHeader.get(j);
//                    if(header.equals(key))
//                    {
//                        txtListChildCategory.setText(be.getExpCategory());
//                        txtListChildDate.setText(values.get(i+1));
//                        txtListChildExpense.setText(values.get(i+2));
//                        childPosition++;
//
//                    }
//                }
//            }
//        }
//
//


//                    for(int i=0;i<values.size();i+=3) {
//                        txtListChildCategory.setText(values.get(i));
//                        txtListChildDate.setText(values.get(i + 1));
//                        txtListChildExpense.setText(values.get(i + 2));
//                    }
//                    int j=0;
//                    for(int i=0;i<values.size();i+=3)
//                    {
//
//                        while (j<_listDataHeader.size())
//                        {
//                            if(_listDataHeader.get(j)==key)
//                            {
//
//
//                                txtListChildCategory.setText(getChild(1,0)+values.get(i));
//                                txtListChildDate.setText(getChild(1,0)+values.get(i+1));
//                                txtListChildExpense.setText(getChild(1,0)+values.get(i+2));
//
//                                j++;
//                            }
//                            j++;
//                        }
//
//                    }

//                if(_listDataHeader.get(0)==key)
        return convertView


//

//      \
    }

    override fun getChildrenCount(groupPosition: Int): Int {

        //Toast.makeText(_context,this._listDataChild.get(this._listDataHeader.get(groupPosition)).size()/3+"----"+this._listDataChild.get(this._listDataHeader.get(groupPosition)).size(),Toast.LENGTH_SHORT).show();
        return _listDataChild.size
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

        // final BeanExpParent parentdetail=parents.get(groupPosition);
        if (convertView == null) {
            val infalInflater = _context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = infalInflater.inflate(R.layout.lst_grp_expense, null)
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

    init {
        list = ArrayList()
        this.arrayChild = arrayChild
        this.strdemo = strdemo
        bep = BeanExpParent()
        parentdetai = BeanExpParent()
        childdetail = BeanExpChild()
        bec = BeanExpChild()
    }
}