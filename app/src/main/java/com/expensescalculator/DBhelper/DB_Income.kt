package com.expensescalculator.DBhelper

import android.content.ContentValues
import android.content.Context
import android.util.Log
import com.expensescalculator.Bean.BeanIncome
import com.expensescalculator.Utility.Constant
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper
import java.util.*


class DB_Income(context: Context?) : SQLiteAssetHelper(context, Constant.dbName, null, Constant.dbVersion) {
    //
    //    public  void insertIncome(BeanIncome bi)
    //    {
    //        SQLiteDatabase db=getWritableDatabase();
    //        ContentValues cv=new ContentValues();
    //        cv.put("IncID",bi.getIncID());
    //        cv.put("IncDate",bi.getIncDate());
    //        cv.put("IncCatID",bi.getIncCatID());
    //        cv.put("IncPayer",bi.getIncPayer());
    //        cv.put("IncDescription",bi.getIncDiscription());
    //        cv.put("IncMonth",bi.getIncMonth());
    //        cv.put("IncDay",bi.getIncDay());
    //        cv.put("IncYear",bi.getIncYear());
    //        db.insert("EC_Income", null, cv);
    //        db.close();
    //
    //
    //
    //    }
    fun insertIncome(bi: BeanIncome) {
        var incID = 1
        val db1 = readableDatabase
        val strQuery = "select MAX(IncID) as HighestValue from EC_Income"
        val cur = db1.rawQuery(strQuery, null)
        if (cur.moveToFirst()) {
            if (cur.count > 0) incID = cur.getInt(cur.getColumnIndex("HighestValue")) + 1
        }
        val db = writableDatabase
        val cv = ContentValues()
        cv.put("IncID", incID)
        cv.put("IncDate", bi.incDate)
        cv.put("IncIncome", bi.incIncome)
        cv.put("IncCatID", bi.incCatID)
        cv.put("IncPayer", bi.incPayer)
        cv.put("IncDescription", bi.incDiscription)
        cv.put("IncMonth", bi.incMonth)
        cv.put("IncYear", bi.incYear)
        cv.put("IncDay", bi.incDay)
        db.insert("EC_Income", null, cv)
        db.close()
    }

    fun selectAllIIncome(Month: String): ArrayList<BeanIncome> {
        val arrayAllIncome = ArrayList<BeanIncome>()
        val db = readableDatabase
        val query = "select * from EC_Income where IncMonth='$Month'"
        val c = db.rawQuery(query, null)
        Log.d("hello", c.count.toString())
        if (c.moveToFirst()) {
            do {
                val binc = BeanIncome()
                binc.incID = c.getInt(c.getColumnIndex("IncID"))
                binc.incDate = c.getString(c.getColumnIndex("IncDate"))
                binc.incIncome = c.getString(c.getColumnIndex("IncIncome"))
                binc.incCatID = c.getInt(c.getColumnIndex("IncCatID"))
                binc.incPayer = c.getString(c.getColumnIndex("IncPayer"))
                binc.incDiscription = c.getString(c.getColumnIndex("IncDescription"))
                binc.incMonth = c.getString(c.getColumnIndex("IncMonth"))
                arrayAllIncome.add(binc)
            } while (c.moveToNext())
        }
        db.close()
        return arrayAllIncome
    }

    fun selectDistinctMonth(): ArrayList<BeanIncome> {
        val arrayDistinctMonth = ArrayList<BeanIncome>()
        val db = readableDatabase
        val query = "select distinct(IncMonth) from EC_Income"
        val c = db.rawQuery(query, null)

        //Log.d("hello", String.valueOf(c.getCount()));
        if (c.moveToFirst()) {
            do {
                val binc = BeanIncome()
                binc.incMonth = c.getString(c.getColumnIndex("IncMonth"))
                arrayDistinctMonth.add(binc)
            } while (c.moveToNext())
        }
        db.close()
        return arrayDistinctMonth
    }

    fun getMonthName(Month: String): String {
        val db = readableDatabase
        val query = "select ExpMonthName from EC_Month where ExpMonthID=$Month"
        val cursor = db.rawQuery(query, null)
        cursor.moveToFirst()
        var strMonth = ""
        if (cursor.moveToFirst()) strMonth = cursor.getString(cursor.getColumnIndex("ExpMonthName"))
        db.close()
        return strMonth
    } /*public ArrayList<BeanIncome> selectAllIncome() {
        ArrayList<BeanIncome> arrayAllIncome = new ArrayList<BeanIncome>();
        SQLiteDatabase db = getReadableDatabase();
        String query = "select * from EC_Income";
        Cursor c = db.rawQuery(query, null);

        //Log.d("hello", String.valueOf(c.getCount()));
        if (c.moveToFirst()) {
            do {
                BeanIncome binc = new BeanIncome();
                binc.setIncID(c.getInt(c.getColumnIndex("IncID")));
                binc.setIncDate(c.getString(c.getColumnIndex("IncDate")));
                binc.setIncCatID(c.getInt(c.getColumnIndex("IncCatID")));
                binc.setIncIncome(c.getString(c.getColumnIndex("IncIncome")));
                binc.setIncPayer(c.getString(c.getColumnIndex("IncPayer")));
                binc.setIncDiscription(c.getString(c.getColumnIndex("IncDescription")));
                arrayAllIncome.add(binc);

            } while (c.moveToNext());

        }
        db.close();
        return arrayAllIncome;

    }*/
    /*public Cursor allIncome()
    {
        SQLiteDatabase db=this.getReadableDatabase();
        String query = "select * from EC_Income";
        Cursor c = db.rawQuery(query, null);
        return c;
    }*/
}