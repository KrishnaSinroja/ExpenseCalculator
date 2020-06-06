package com.expensescalculator.DBhelper

import android.content.Context
import android.util.Log
import com.expensescalculator.Bean.BeanExpenseCategory
import com.expensescalculator.Utility.Constant
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper
import java.util.*

class DB_ExpenseCategory(context: Context?) : SQLiteAssetHelper(context, Constant.dbName, null, Constant.dbVersion) {
    fun selectAllExpCat(): ArrayList<BeanExpenseCategory> {
        val arrayExpCategory = ArrayList<BeanExpenseCategory>()
        val db = readableDatabase
        val query = "select * from EC_Exp_Category"
        val c = db.rawQuery(query, null)
        Log.d("hello", c.count.toString())
        if (c.moveToFirst()) {
            do {
                val bec = BeanExpenseCategory()
                bec.expCatID = c.getInt(c.getColumnIndex("ExpCatID"))
                bec.expCatName = c.getString(c.getColumnIndex("ExpCatName"))
                arrayExpCategory.add(bec)
            } while (c.moveToNext())
        }
        db.close()
        return arrayExpCategory
    }

    fun selectById(expCatID: Int): String {
        val db = readableDatabase
        val query = "select ExpCatName from EC_Exp_Category where ExpCatID=$expCatID"
        val cursor = db.rawQuery(query, null)
        cursor.moveToFirst()
        var strCat = ""
        if (cursor.moveToFirst()) strCat = cursor.getString(cursor.getColumnIndex("ExpCatName"))
        db.close()
        return strCat
    }
}