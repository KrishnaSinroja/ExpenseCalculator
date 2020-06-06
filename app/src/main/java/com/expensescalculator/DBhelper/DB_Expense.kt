package com.expensescalculator.DBhelper

import android.content.ContentValues
import android.content.Context
import android.util.Log
import com.expensescalculator.Bean.BeanExpense
import com.expensescalculator.Utility.Constant
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper
import java.util.*


class DB_Expense(context: Context?) : SQLiteAssetHelper(context, Constant.dbName, null, Constant.dbVersion) {
    //
    //    public  void insertExpense(BeanExpense be)
    //    {
    //
    //        SQLiteDatabase db=getWritableDatabase();
    //        ContentValues cv=new ContentValues();
    //        //cv.put("ExpID",be.getExpID());
    //        cv.put("ExpDate",be.getExpDate());
    //        cv.put("ExpExpense",be.getExpExpense());
    //        cv.put("ExpCatID",be.getExpCategory());
    //        cv.put("ExpPayee",be.getExpPayee());
    //        cv.put("ExpDescription", be.getExpDiscription());
    //        cv.put("ExpMonth",be.getExpMonth());
    //        cv.put("ExpYear",be.getExpYear());
    //        cv.put("ExpDay",be.getExpDay());
    //
    //
    //
    //        db.insert("EC_Expense", null, cv);
    //
    //        Log.d("ExpId----------->>>>", String.valueOf(be.getExpID()));
    //
    //        db.close();
    //
    //
    //
    //    }
    fun insertExpense(be: BeanExpense) {
        var expID = 1
        val db1 = readableDatabase
        val strQuery = "select MAX(ExpID) as HighestValue from EC_Expense"
        val cur = db1.rawQuery(strQuery, null)
        if (cur.moveToFirst()) {
            if (cur.count > 0) expID = cur.getInt(cur.getColumnIndex("HighestValue")) + 1
        }
        val db = writableDatabase
        val cv = ContentValues()
        cv.put("ExpID", expID)
        cv.put("ExpDate", be.expDate)
        cv.put("ExpExpense", be.expExpense)
        cv.put("ExpCatID", be.expCatID)
        cv.put("ExpPayee", be.expPayee)
        cv.put("ExpDescription", be.expDiscription)
        cv.put("ExpMonth", be.expMonth)
        cv.put("ExpYear", be.expYear)
        cv.put("ExpDay", be.expDay)
        db.insert("EC_Expense", null, cv)
        db.close()
    }

    fun getCatName(name: Int): String {
        val db = readableDatabase
        val i: String
        val c = db.rawQuery("select ExpCatName from EC_Exp_Category where ExpCatID = '$name'", null)
        i = if (c.moveToFirst()) {
            c.getString(c.getColumnIndex("ExpCatName"))
        } else {
            ""
        }
        return i
    }

    fun selectAllIExpense(Month: String): ArrayList<BeanExpense?> {
        val arrayAllExpense = ArrayList<BeanExpense?>()
        val db = readableDatabase
        val query = "select * from EC_Expense where ExpMonth='$Month'"
        val c = db.rawQuery(query, null)
        Log.d("size------+--->", c.count.toString())
        if (c.moveToFirst()) {
            do {
                val bexp = BeanExpense()
                bexp.expID = c.getInt(c.getColumnIndex("ExpID"))
                bexp.expDate = c.getString(c.getColumnIndex("ExpDate"))
                bexp.expCatID = c.getInt(c.getColumnIndex("ExpCatID"))
                bexp.expExpense = c.getString(c.getColumnIndex("ExpExpense"))
                bexp.expPayee = c.getString(c.getColumnIndex("ExpPayee"))
                bexp.expDiscription = c.getString(c.getColumnIndex("ExpDescription"))
                arrayAllExpense.add(bexp)
            } while (c.moveToNext())
        }
        db.close()
        return arrayAllExpense
    }

    val allRecords: ArrayList<BeanExpense>
        get() {
            val arrayAllExpense = ArrayList<BeanExpense>()
            val db = readableDatabase
            val query = "select * from EC_Expense"
            val c = db.rawQuery(query, null)
            if (c.moveToFirst()) {
                do {
                    val bexp = BeanExpense()
                    bexp.expID = c.getInt(c.getColumnIndex("ExpID"))
                    bexp.expDate = c.getString(c.getColumnIndex("ExpDate"))
                    bexp.expCatID = c.getInt(c.getColumnIndex("ExpCatID"))
                    bexp.expExpense = c.getString(c.getColumnIndex("ExpExpense"))
                    bexp.expPayee = c.getString(c.getColumnIndex("ExpPayee"))
                    bexp.expDiscription = c.getString(c.getColumnIndex("ExpDescription"))
                    bexp.expCategory = getCatName(bexp.expCatID)
                    bexp.expMonth = c.getString(c.getColumnIndex("ExpMonth"))
                    arrayAllExpense.add(bexp)
                } while (c.moveToNext())
            }
            db.close()
            return arrayAllExpense
        }

    fun selectDistinctMonth(): ArrayList<BeanExpense> {
        val arrayDistinctMonth = ArrayList<BeanExpense>()
        val db = readableDatabase
        val query = "select distinct(ExpMonth) from EC_Expense"
        val c = db.rawQuery(query, null)
        Log.d("size-------->>>", c.count.toString())
        if (c.moveToFirst()) {
            do {
                val bexp = BeanExpense()
                bexp.expMonth = c.getString(c.getColumnIndex("ExpMonth"))
                arrayDistinctMonth.add(bexp)
            } while (c.moveToNext())
        }
        db.close()
        return arrayDistinctMonth
    }

    fun getMonthName(Month: String?): String {
        val db = readableDatabase
        val query = "select ExpMonthName from EC_Month where ExpMonthID=$Month"
        val cursor = db.rawQuery(query, null)
        cursor.moveToFirst()
        var strMonth = ""
        if (cursor.moveToFirst()) strMonth = cursor.getString(cursor.getColumnIndex("ExpMonthName"))
        db.close()
        return strMonth
    }
}